package ar.com.mycompany.product.offering.infra.outbound.dao;

import ar.com.mycompany.product.offering.domain.ProductPrice;
import ar.com.mycompany.product.offering.domain.dao.IProductPriceDAO;
import ar.com.mycompany.product.offering.dto.ProductOfferingCriteria;
import ar.com.mycompany.product.offering.infra.outbound.dao.entity.PriceEntity;
import ar.com.mycompany.product.offering.infra.outbound.dao.mapper.IPriceEntityMapper;
import ar.com.mycompany.product.offering.infra.outbound.dao.repository.PriceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Aquiles Diaz (aediaz05@gmail.com)
 */
@Slf4j
@Service
public class JPAProductDAO implements IProductPriceDAO {

    @Autowired
    private PriceRepository priceRepository;

    @Autowired
    private IPriceEntityMapper mapper;

    @Override
    public List<ProductPrice> searchByCriteria(@NotNull ProductOfferingCriteria productPriceCriteria) {

        try {
            List<PriceEntity> priceEntity = priceRepository.findUsingFilters(
                    productPriceCriteria.getProductId(),
                    productPriceCriteria.getBrandId(),
                    Timestamp.valueOf(productPriceCriteria.getApplicationDate()));

            return priceEntity
                    .stream()
                    .map(mapper::map)
                    .collect(Collectors.toList());

        } catch (Exception e){
            throw new IllegalStateException(e);
        }
    }
}
