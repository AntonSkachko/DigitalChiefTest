package org.bsuir.digitalchieftest.model.dto.response;

public record ErrorResponseTo(
        int code, String message, String[] errorsMessages) {
}
