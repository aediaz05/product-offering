package ar.com.mycompany.product.offering.infra.inbound.rest.conf;

import ar.com.mycompany.product.offering.domain.exceptions.PriceNotFound;
import ar.com.mycompany.product.offering.domain.exceptions.TooManyPrices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * This class defines handlers to manage the responses of the API
 *
 * @author Aquiles Diaz (aediaz05@gmail.com)
 */
@RestControllerAdvice
class GlobalRestControllerExceptionHandler {

    /**
     * Method used to handle exceptions of {@link PriceNotFound}
     *
     * @param e the exception occurred
     * @return an instance of {@link ResponseEntity } whit status {@link HttpStatus#NO_CONTENT }
     */
    @ExceptionHandler(PriceNotFound.class)
    @ResponseStatus(
            code = HttpStatus.NO_CONTENT,
            reason = "No data to return")
    ResponseEntity<Object> handlePriceNotFound(RuntimeException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NO_CONTENT);
    }

    /**
     * Method used to handle any of this exceptions:
     *
     * <li>{@link TooManyPrices}<li/>
     * <li>{@link IllegalStateException}<li/>
     * <li>{@link IllegalArgumentException}<li/>
     *
     * @param e the exception occurred
     * @return an instance of {@link ResponseEntity } whit status {@link HttpStatus#CONFLICT }
     */
    @ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class, TooManyPrices.class })
    @ResponseStatus(
            code = HttpStatus.CONFLICT,
            reason = "The request could not be processed because of conflict in the request.")
    ResponseEntity<Object> handleConflict(RuntimeException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }
}