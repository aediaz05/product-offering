package ar.com.mycompany.product.offering.infra.inbound.rest;

import ar.com.mycompany.product.offering.dto.ProductOffering;
import ar.com.mycompany.product.offering.dto.ProductOfferingCriteria;
import ar.com.mycompany.product.offering.services.spec.IProductOffering;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

/**
 * Class used to define entrypoints of the service.
 * This is responsible to resolve product offering requests
 *
 * @author Aquiles Diaz (aediaz05@gmail.com)
 */
@Slf4j
@RestController
@RequestMapping("/api/product-offering")
class ProductOfferingController {

    @Autowired
    private IProductOffering iProductOffering;

    @GetMapping
    ResponseEntity<ProductOffering> search(@Validated ProductOfferingCriteria productPriceCriteria) {
        log.info("Search products using criteria: [{}]", HtmlUtils.htmlEscape(productPriceCriteria.toString()));
        ProductOffering productOffering = iProductOffering.getOne(productPriceCriteria);
        return ResponseEntity.ok(productOffering);
    }
}
