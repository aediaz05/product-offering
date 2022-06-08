package ar.com.mycompany.product.offering.services;

import ar.com.mycompany.product.offering.domain.ProductPrice;
import ar.com.mycompany.product.offering.domain.dao.IProductPriceDAO;
import ar.com.mycompany.product.offering.domain.exceptions.PriceNotFound;
import ar.com.mycompany.product.offering.dto.ProductOffering;
import ar.com.mycompany.product.offering.dto.ProductOfferingCriteria;
import ar.com.mycompany.product.offering.services.mapper.IProductOfferingMapper;
import ar.com.mycompany.product.offering.services.spec.IProductOffering;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Comparator;
import java.util.Optional;

/**
 * This class implements business logic to attend or complete a product offering requests.
 * @see IProductOffering
 *
 * @author Aquiles Diaz (aediaz05@gmail.com)
 */
@Slf4j
@Service
class ProductOfferingService implements IProductOffering {

    @Autowired
    private IProductPriceDAO productDAO;

    @Autowired
    private IProductOfferingMapper mapper;

    @Override
    public ProductOffering getOne(@NotNull ProductOfferingCriteria productPriceCriteria) {
        log.info("get products using criteria {}", productPriceCriteria);

        return Optional.ofNullable(productDAO.searchByCriteria(productPriceCriteria))
                .orElseThrow(() -> new PriceNotFound(productPriceCriteria))
                .stream()
                .sorted(Comparator.comparing(ProductPrice::getPriority).reversed())
                .limit(1)
                .findFirst()
                .map(mapper::map)
                .orElseThrow(() -> new PriceNotFound(productPriceCriteria));
    }


}
