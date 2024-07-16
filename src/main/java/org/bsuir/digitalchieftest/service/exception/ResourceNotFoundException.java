package org.bsuir.digitalchieftest.service.exception;

public class ResourceNotFoundException extends ResourceException{

    public ResourceNotFoundException(int code, String message) {
        super(code, message);
    }
}
