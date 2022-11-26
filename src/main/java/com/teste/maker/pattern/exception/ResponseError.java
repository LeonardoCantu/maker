package com.teste.maker.pattern.exception;

import lombok.Data;

import java.util.Calendar;
import java.util.Date;

@Data
public class ResponseError {

    public String message;

    public Date date;

    public StackTraceElement[] trace;

    public ResponseError(String message, Date timestamp, String error) {
        this.message = message;
        this.date = timestamp;
    }

    public ResponseError(Throwable exception){
        this.message = exception.getMessage();
        this.date = Calendar.getInstance().getTime();
        this.trace = exception.getStackTrace();
    }
}
