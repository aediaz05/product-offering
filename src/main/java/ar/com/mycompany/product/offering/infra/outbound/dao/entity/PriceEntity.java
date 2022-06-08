package ar.com.mycompany.product.offering.infra.outbound.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Entity Object used to describe <b>Product</b>
 *
 * @author Aquiles Diaz (aediaz05@gmail.com)
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "prices")
public class PriceEntity {

    @Id
    @Column(name = "id", updatable = false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "product_id", updatable = false)
    private long productId;

    @Column(name = "brand_id", updatable = false)
    private long brandId;

    @ToString.Exclude
    @Column(name = "start_date", updatable = false)
    private Timestamp startDate;

    @ToString.Exclude
    @Column(name = "end_date", updatable = false)
    private Timestamp endDate;

    @Column(name = "price_list", updatable = false)
    private int priceList;

    @Column(name = "priority", updatable = false)
    private int priority;

    @ToString.Exclude
    @Column(name = "price", updatable = false)
    private double price;

    @ToString.Exclude
    @Column(name = "curr", updatable = false)
    private String currency;
}
