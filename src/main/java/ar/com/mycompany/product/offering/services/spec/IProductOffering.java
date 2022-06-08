package ar.com.mycompany.product.offering.services.spec;

import ar.com.mycompany.product.offering.dto.ProductOffering;
import ar.com.mycompany.product.offering.dto.ProductOfferingCriteria;

/**
 * Interface that defines the methods that can be used to attend or complete a product offering requests.
 *
 * @author Aquiles Diaz (aediaz05@gmail.com)
 */
public interface IProductOffering {

    /**
     *
     * @param productPriceCriteria
     * @return
     */
    ProductOffering getOne(ProductOfferingCriteria productPriceCriteria);
}
