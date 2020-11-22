package ru.otus.spring.FinancialDistribution.pagecontrollers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Optional;

@ControllerAdvice
public class SecuriryAdvice {

    private final Logger log = LoggerFactory.getLogger(SecuriryAdvice.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleAnyError(Exception ex){
            log.error("error", ex);
            return ResponseEntity.of(Optional.of("error"));
    }
}
