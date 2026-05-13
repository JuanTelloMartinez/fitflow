package es.ieslavereda.fitflow.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String, String>> handleNotFound(ResourceNotFoundException ex) {
		Map<String, String> response = new HashMap<>();
		response.put("error", ex.getMessage());
		response.put("status", "404");

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<Map<String, String>> handleBadRequest(BadRequestException ex) {
		Map<String, String> response = new HashMap<>();
		response.put("error", ex.getMessage());
		response.put("status", "400");

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleValidation(MethodArgumentNotValidException ex) {
		Map<String, String> response = new HashMap<>();

		String errorMessage = ex.getBindingResult()
				  .getFieldErrors()
				  .stream()
				  .findFirst()
				  .map(error -> error.getField() + ": " + error.getDefaultMessage())
				  .orElse("Petición no válida");

		response.put("error", errorMessage);
		response.put("status", "400");

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<Map<String, String>> handleUnreadableMessage(HttpMessageNotReadableException ex) {
		Map<String, String> response = new HashMap<>();
		String errorMessage = "JSON no valido o valor incompatible. Revisa fechas y enums como MENSUAL/ACTIVO.";

		response.put("error", errorMessage);
		response.put("status", "400");

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
}
