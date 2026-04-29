package com.icthh.xm.tmf.ms.promotion.web.rest.errors;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class BadRequestAlertException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final URI type;

    private final String entityName;

    private final String errorKey;

    public BadRequestAlertException(String defaultMessage, String entityName, String errorKey) {
        this(ErrorConstants.DEFAULT_TYPE, defaultMessage, entityName, errorKey);
    }

    public BadRequestAlertException(URI type, String defaultMessage, String entityName, String errorKey) {
        super(defaultMessage);
        this.type = type;
        this.entityName = entityName;
        this.errorKey = errorKey;
    }

    public  URI getType() { return type; }

    public String getEntityName() {
        return entityName;
    }

    public String getErrorKey() {
        return errorKey;
    }

    public Map<String, Object> getParameters() {
        return Map.of(
            "message", "error." + errorKey,
            "params", entityName
        );
    }
}
