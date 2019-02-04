package com.ak4.exception;

import javax.ws.rs.WebApplicationException;

public class UserAlreadyExistException extends WebApplicationException {
    public UserAlreadyExistException(String user_is_already_exist) {
        super(user_is_already_exist);
    }
}
