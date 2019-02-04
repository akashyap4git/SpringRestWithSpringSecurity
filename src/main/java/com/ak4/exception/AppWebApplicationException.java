package com.ak4.exception;

import javax.ws.rs.WebApplicationException;

public class AppWebApplicationException extends WebApplicationException {
    public AppWebApplicationException(String s) {
        super(s);
    }
}
