package ar.com.mycompany.product.offering.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.Comparator;

/**
 * Domain Object used to describe plain <b>ProductPrice</b> object
 *
 * @author Aquiles Diaz (aediaz05@gmail.com)
 */
@Builder
@Value
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProductPrice implements Comparable<ProductPrice>, Comparator<ProductPrice> {

    @EqualsAndHashCode.Include
    long id;

    @EqualsAndHashCode.Include
    long brandId;

    @ToString.Exclude
    LocalDateTime startDate;

    @ToString.Exclude
    LocalDateTime endDate;

    int rate;

    @EqualsAndHashCode.Include
    int priority;

    @ToString.Exclude
    double price;

    @ToString.Exclude
    String currency;

    @Override
    public int compare(ProductPrice o1, ProductPrice o2) {
        return Integer.compare(o1.getPriority(), o2.getPriority());
    }

    @Override
    public int compareTo(ProductPrice o) {
        return Integer.compare(this.getPriority(), o.getPriority());
    }
}
