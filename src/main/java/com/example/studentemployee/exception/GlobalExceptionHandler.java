package com.example.studentemployee.exception;
import org.springframework.http.*; import org.springframework.web.bind.annotation.*; import java.util.Map;
@RestControllerAdvice
public class GlobalExceptionHandler {
 @ExceptionHandler(PersonNotFoundException.class) ResponseEntity<?> nf(PersonNotFoundException e){return ResponseEntity.status(404).body(Map.of("error",e.getMessage()));}
 @ExceptionHandler(BadRequestException.class) ResponseEntity<?> br(BadRequestException e){return ResponseEntity.badRequest().body(Map.of("error",e.getMessage()));}
}
