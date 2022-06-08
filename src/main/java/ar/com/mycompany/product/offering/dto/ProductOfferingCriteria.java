package ar.com.mycompany.product.offering.dto;

import lombok.ToString;
import lombok.Value;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO used encapsulate all the allowed filters using to search product offering.
 *
 * @author Aquiles Diaz (aediaz05@gmail.com)
 */
@Value
@Accessors(chain = true)
@ToString
public class ProductOfferingCriteria implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    LocalDateTime applicationDate;

    @NotNull
    Long productId;

    @NotNull
    Long brandId;
}
