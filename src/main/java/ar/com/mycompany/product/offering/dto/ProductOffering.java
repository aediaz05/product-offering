package ar.com.mycompany.product.offering.dto;

import lombok.Builder;
import lombok.Value;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Data Transfer Object that contains the information of product price from service layer.
 *
 * @author Aquiles Diaz (aediaz05@gmail.com)
 */
@Value
@Builder
public class ProductOffering implements Serializable {

    private static final long serialVersionUID = 1L;

    long productId;

    long brandId;

    double price;

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    LocalDateTime startDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    LocalDateTime endDate;
}
