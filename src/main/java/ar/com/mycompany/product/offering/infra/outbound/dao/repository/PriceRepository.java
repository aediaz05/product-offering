package ar.com.mycompany.product.offering.infra.outbound.dao.repository;

import ar.com.mycompany.product.offering.infra.outbound.dao.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Aquiles Diaz (aediaz05@gmail.com)
 */
@Repository
public interface PriceRepository extends
        JpaRepository<PriceEntity, Long> {

    /**
     * Method used to get a {@link PriceEntity} using filters
     *
     * @param productId the prodict id
     * @param brandId the brand id
     * @param applicationDate the application date
     *
     * @return An {@link Optional} instance of {@link PriceEntity}
     */
    @Query("SELECT pe FROM PriceEntity pe" +
            " WHERE pe.productId = :productId" +
            "   AND pe.brandId = :brandId" +
            "   AND :applicationDate between pe.startDate and pe.endDate")
    List<PriceEntity> findUsingFilters(long productId, long brandId, Timestamp applicationDate);
}
