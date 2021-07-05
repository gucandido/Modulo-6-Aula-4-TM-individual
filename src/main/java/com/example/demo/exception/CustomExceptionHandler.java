package com.example.demo.exception;

import com.example.demo.dto.ExceptionDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(LinkNotFound.class)
    public ResponseEntity<ExceptionDto> defaultHandler(LinkNotFound e){

        ExceptionDto ex = new ExceptionDto(e.getMessage());
        ex.setStack(e.getStackTrace().toString());
        return ResponseEntity.badRequest().body(ex);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ExceptionDto>> defaultHandler(MethodArgumentNotValidException e){
        BindingResult result = e.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        List<ExceptionDto> processFieldErrors = processFieldErrors(fieldErrors);
        return ResponseEntity.badRequest().body(processFieldErrors);
    }

    private List<ExceptionDto> processFieldErrors(List<FieldError> fieldErrors) {
        List<ExceptionDto> listaDtos = new ArrayList<>();
        for (FieldError fieldError: fieldErrors) {
            listaDtos.add(new ExceptionDto(fieldError.getField(), fieldError.getDefaultMessage()));

        }
        return listaDtos;
    }


}
