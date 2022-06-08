package ar.com.mycompany.product.offering.infra.outbound.dao.mapper;

import ar.com.mycompany.product.offering.domain.ProductPrice;
import ar.com.mycompany.product.offering.infra.outbound.dao.entity.PriceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Represents a mapper interface of {@link Mapper} used to transform an {@link PriceEntity} object
 * to an {@link ProductPrice} object, it's used to hide database model from the application.
 *
 * @see Mapping
 * @see Mapper
 *
 * @author Aquiles Diaz (aediaz05@gmail.com)
 */
@Mapper(componentModel = "spring")
public interface IPriceEntityMapper {

    /**
     * Map a {@link PriceEntity} instance to a {@link ProductPrice} instance.
     *
     * @param priceEntity the {@link PriceEntity}.
     * @return the {@link ProductPrice} instance.
     *
     */
    @Mapping(source = "productId",  target = "id")
    @Mapping(source = "brandId",    target = "brandId")
    @Mapping(source = "startDate",  target = "startDate")
    @Mapping(source = "endDate",    target = "endDate")
    @Mapping(source = "priceList",  target = "rate")
    @Mapping(source = "priority",   target = "priority")
    @Mapping(source = "price",      target = "price")
    @Mapping(source = "currency",   target = "currency")
    ProductPrice map(PriceEntity priceEntity);

    /**
     * Default method to map a {@link Timestamp} instance to a {@link LocalDateTime} instance.
     *
     * @param timestamp the {@link Timestamp}.
     * @return the {@link LocalDateTime} instance.
     */
    default LocalDateTime map(Timestamp timestamp){
        return timestamp.toLocalDateTime();
    }

}
