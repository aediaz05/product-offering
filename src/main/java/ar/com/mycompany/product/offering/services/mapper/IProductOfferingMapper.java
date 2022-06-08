package ar.com.mycompany.product.offering.services.mapper;

import ar.com.mycompany.product.offering.domain.ProductPrice;
import ar.com.mycompany.product.offering.dto.ProductOffering;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Represents a mapper interface of {@link Mapper} used to transform a {@link ProductPrice} object
 * to a {@link ProductOffering} object, so it only includes the information that is of interest in the response.
 *
 * @see Mapping
 * @see Mapper
 *
 * @author Aquiles Diaz (aediaz05@gmail.com)
 */
@Mapper(componentModel = "spring")
public interface IProductOfferingMapper {

    /**
     * Map a {@link ProductPrice} instance to a {@link ProductOffering} instance.
     *
     * @param productPrice the {@link ProductPrice}.
     * @return the {@link ProductOffering} instance.
     *
     */
    @Mapping(source = "id",         target = "productId")
    @Mapping(source = "brandId",    target = "brandId")
    @Mapping(source = "price",      target = "price")
    @Mapping(source = "startDate",  target = "startDate")
    @Mapping(source = "endDate",    target = "endDate")
    ProductOffering map(ProductPrice productPrice);
}
