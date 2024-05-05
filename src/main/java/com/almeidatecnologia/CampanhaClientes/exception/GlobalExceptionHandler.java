package com.almeidatecnologia.CampanhaClientes.exception;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.HashMap;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;





@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<ErrorTreatment> database(DatabaseException e, HttpServletRequest request){
		String error = "Erro de Banco de Dados.";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ErrorTreatment err = new ErrorTreatment(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Map<String, List<String>>> handleGeneralExceptions(Exception ex) {        
        List<String> errors = Collections.singletonList(ex.getMessage());
        return new ResponseEntity<>(getErrorsMap(errors), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ClienteNotFoundException.class)
    public Map<String, String> handlePessoaNotFoundException(ClienteNotFoundException ex){
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("erro", ex.getMessage());
        return errorMap;
    }

    @ExceptionHandler(BeneficioNotFoundException.class)
    public Map<String, String> handleContatoNotFoundException(BeneficioNotFoundException ex){
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("erro", ex.getMessage());
        return errorMap;
    }

    @ExceptionHandler(RuntimeException.class)
    public final ResponseEntity<Map<String, List<String>>> handleRuntimeExceptions(RuntimeException ex) {
        List<String> errors = Collections.singletonList(ex.getMessage());
        return new ResponseEntity<>(getErrorsMap(errors), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


    private Map<String, List<String>> getErrorsMap(List<String> errors) {
        Map<String, List<String>> errorResponse = new HashMap<>();
        errorResponse.put("errors", errors);
        return errorResponse;
    }
	
}