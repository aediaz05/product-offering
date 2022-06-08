package ar.com.mycompany.product.offering.domain.exceptions;

import ar.com.mycompany.product.offering.dto.ProductOfferingCriteria;

/**
 * This defined exception is used when results contain more than
 * one record using an instance of {@link ProductOfferingCriteria}
 *
 * @author Aquiles Diaz (aediaz05@gmail.com)
 */
public final class TooManyPrices extends RuntimeException {

    private static final String ERR = "The results contain more than one row using the criteria: %s";

    /**
     * Default constructor
     *
     * @param productPriceCriteria The object used when occurs error
     */
    public TooManyPrices(ProductOfferingCriteria productPriceCriteria, Throwable throwable){
        super(String.format(ERR, productPriceCriteria), throwable);
    }
}
