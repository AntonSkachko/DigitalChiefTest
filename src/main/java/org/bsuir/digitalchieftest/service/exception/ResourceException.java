package org.bsuir.digitalchieftest.service.exception;

import lombok.Getter;
import org.bsuir.digitalchieftest.model.dto.response.ErrorResponseTo;

@Getter
public class ResourceException extends RuntimeException {

    private final ErrorResponseTo errorResponseTo;

    public ResourceException(int code, String message) {
        super(message);
        errorResponseTo = new ErrorResponseTo(code, message, null);
    }
}
