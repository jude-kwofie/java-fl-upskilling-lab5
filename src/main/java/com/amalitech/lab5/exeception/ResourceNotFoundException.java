package com.amalitech.lab5.exeception;

import org.springframework.http.ProblemDetail;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

public class ResourceNotFoundException  extends RuntimeException{
    public ResourceNotFoundException(String message){
        super(message);
    }

    public ProblemDetail toProblem(){
        return  ProblemDetail.forStatusAndDetail(BAD_REQUEST,this.getMessage());
    }
}
