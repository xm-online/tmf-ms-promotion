package com.icthh.xm.tmf.ms.promotion.web.rest.errors;

public class EmailNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public EmailNotFoundException() {
        super("Email address not registered");
    }
}
