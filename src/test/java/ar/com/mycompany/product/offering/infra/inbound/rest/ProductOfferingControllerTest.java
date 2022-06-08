package ar.com.mycompany.product.offering.infra.inbound.rest;

import ar.com.mycompany.product.offering.dto.ProductOffering;
import ar.com.mycompany.product.offering.dto.ProductOfferingCriteria;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Aquiles Diaz (aquiles.diaz@smartmatic.com)
 */
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@TestPropertySource("classpath:test.properties")
class ProductOfferingControllerTest {

    @Autowired
    private ProductOfferingController controller;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @DisplayName("Retrieve the product price")
    @ParameterizedTest(name = "{index} => a={0}, b={1}, sum={2}")
    @MethodSource("argumentProvider")
    void testRequired(String index, ProductOfferingCriteria criteria, ProductOffering expected) throws Exception {

        String url = UriComponentsBuilder.fromHttpUrl("http://localhost:" + port + "/api/product-offering")
                .queryParam("applicationDate", criteria.getApplicationDate())
                .queryParam("productId", criteria.getProductId())
                .queryParam("brandId", criteria.getBrandId())
                .encode()
                .toUriString();

        ResponseEntity<ProductOffering> response = restTemplate.getForEntity(url, ProductOffering.class);
        ProductOffering productOffering = response.getBody();
        assertNotNull(productOffering);
        assertEquals(expected.getPrice(), productOffering.getPrice());

    }

    private static Stream<Arguments> argumentProvider(){
        LocalDate day14 = LocalDate.of(2020, 6, 14);
        LocalDate day15 = LocalDate.of(2020, 6, 15);
        LocalDate day16 = LocalDate.of(2020, 6, 16);

        LocalDateTime applicationDate01 = LocalDateTime.of(day14, LocalTime.of(10, 0));
        LocalDateTime applicationDate02 = LocalDateTime.of(day14, LocalTime.of(16, 0));
        LocalDateTime applicationDate03 = LocalDateTime.of(day14, LocalTime.of(21, 0));
        LocalDateTime applicationDate04 = LocalDateTime.of(day15, LocalTime.of(10, 0));
        LocalDateTime applicationDate05 = LocalDateTime.of(day16, LocalTime.of(21, 0));

        ProductOffering expectedOffering01 = ProductOffering.builder().price(35.50).build();
        ProductOffering expectedOffering02 = ProductOffering.builder().price(25.45).build();
        ProductOffering expectedOffering03 = ProductOffering.builder().price(35.50).build();
        ProductOffering expectedOffering04 = ProductOffering.builder().price(30.50).build();
        ProductOffering expectedOffering05 = ProductOffering.builder().price(38.95).build();

        return Stream.of(
                Arguments.of("TEST01", new ProductOfferingCriteria(applicationDate01, 35455L, 1L), expectedOffering01),
                Arguments.of("TEST02", new ProductOfferingCriteria(applicationDate02, 35455L, 1L), expectedOffering02),
                Arguments.of("TEST03", new ProductOfferingCriteria(applicationDate03, 35455L, 1L), expectedOffering03),
                Arguments.of("TEST04", new ProductOfferingCriteria(applicationDate04, 35455L, 1L), expectedOffering04),
                Arguments.of("TEST05", new ProductOfferingCriteria(applicationDate05, 35455L, 1L), expectedOffering05)
        );
    }
}