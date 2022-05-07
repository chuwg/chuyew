package com.tistory.roobistory.chuyew.exception;

import com.tistory.roobistory.chuyew.user.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@ControllerAdvice // 모든 컨트롤러가 실행 시 반드시 이 어너테이션을 가지고 있는 빈이 사전에 실행 됨.
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class) // 이 메소드가 exception 핸들러로로 사용될수 있음을 지칭하는 어노테이션
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        ExceptionResponse  exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class) // 이 메소드가 exception 핸들러로로 사용될수 있음을 지칭하는 어노테이션
    public final ResponseEntity<Object> handleUserNotFoundExceptions(Exception ex, WebRequest request) {
        ExceptionResponse  exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }
}
