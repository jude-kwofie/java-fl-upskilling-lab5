package com.amalitech.lab5.execeptionhandler;

import com.amalitech.lab5.exeception.ConstrainViolation;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestControllerAdvice("com.amalitech")
public class GlobalExceptionHandler   {

    @ExceptionHandler(IllegalAccessException.class)
    public ProblemDetail handleIllegalArgumentException(
            IllegalArgumentException exception
    ){
        return ProblemDetail.forStatusAndDetail(BAD_REQUEST,exception.getMessage());
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public  ProblemDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        String detailMessage = "Valiidation error";
        String detailMessage1 = "detailMessage";
        ProblemDetail validationProblemDetail = ProblemDetail.forStatusAndDetail(BAD_REQUEST, detailMessage);

        List<ConstrainViolation> errors = exception.getFieldErrors()
                .stream()
                .map(violation -> ConstrainViolation.builder()
                        .message(violation.getDefaultMessage())
                        .fieldName(violation.getField())
                        .rejectedValue(Objects.isNull(
                                violation.getRejectedValue()) ?
                                "null": violation.getRejectedValue().toString())
                        .build())
                .collect(Collectors.toList());

        validationProblemDetail.setProperty("errors",errors);
        return validationProblemDetail;

    }
    @ExceptionHandler(Exception.class)
    public ErrorResponse handlerAllExceptions(Exception exception){
        return ErrorResponse
                .builder(exception,INTERNAL_SERVER_ERROR,exception.getMessage())
                .build();
    }
}
