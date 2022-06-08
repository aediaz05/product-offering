package ar.com.mycompany.product.offering;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class ProductOfferingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductOfferingApplication.class, args);
	}

}
