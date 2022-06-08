package ar.com.mycompany.product.offering.domain.exceptions;

import ar.com.mycompany.product.offering.dto.ProductOfferingCriteria;

/**
 * This defined exception is used when no result is found using an instance of {@link ProductOfferingCriteria}
 *
 * @author Aquiles Diaz (aediaz05@gmail.com)
 */
public final class PriceNotFound extends RuntimeException {

    private static final String ERR = "Product price not found using criteria: %s";

    /**
     * Default constructor
     *
     * @param productPriceCriteria The object used when occurs error
     */
    public PriceNotFound(ProductOfferingCriteria productPriceCriteria){
        super(String.format(ERR, productPriceCriteria));
    }
}
