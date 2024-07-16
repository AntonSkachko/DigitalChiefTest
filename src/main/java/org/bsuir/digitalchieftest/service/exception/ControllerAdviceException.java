package org.bsuir.digitalchieftest.service.exception;

import org.bsuir.digitalchieftest.model.dto.response.ErrorResponseTo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdviceException {

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ErrorResponseTo> catchThrowableException(Throwable e) {


        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        return ResponseEntity
                .status(httpStatus)
                .body(takeError(e, httpStatus));
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseTo> catchResourceNotFoundException(ResourceNotFoundException e) {

        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        return ResponseEntity.status(httpStatus).body(takeError(e));
    }



    private static ErrorResponseTo takeError(
            Throwable e, HttpStatus status) {
        return new ErrorResponseTo(
                HttpStatus.BAD_REQUEST.value(),
                "Throwable exception",
                new String [] {e.getMessage()}
        );
    }

    private static ErrorResponseTo takeError(ResourceNotFoundException e) {
        return e.getErrorResponseTo();
    }
}
