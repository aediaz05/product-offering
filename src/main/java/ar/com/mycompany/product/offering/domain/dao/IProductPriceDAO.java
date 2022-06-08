package ar.com.mycompany.product.offering.domain.dao;

import ar.com.mycompany.product.offering.domain.ProductPrice;
import ar.com.mycompany.product.offering.dto.ProductOfferingCriteria;

import java.util.List;

/**
 * This interface defines methods to access or retrieve information of {@link ProductPrice}.
 *
 * @author Aquiles Diaz (aediaz05@gmail.com)
 */
public interface IProductPriceDAO {

    /**
     * Method used to search product prices using {@link ProductOfferingCriteria}.
     * @param productPriceCriteria the values to filter data
     *
     * @return a collection of {@link ProductPrice}
     */
    List<ProductPrice> searchByCriteria(ProductOfferingCriteria productPriceCriteria);
}
