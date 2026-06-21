package inventorymanagement.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandling {

    @ExceptionHandler(value = InsufficientStockException.class)

	public ResponseEntity<String> handlestock (InsufficientStockException exception) {
        return ResponseEntity.badRequest().body (exception.getMessage());
}

	@ExceptionHandler(value = RuntimeException.class)

	public ResponseEntity<String> handlestock (RuntimeException exception) {
         return ResponseEntity.badRequest().body(exception.getMessage());
}
}