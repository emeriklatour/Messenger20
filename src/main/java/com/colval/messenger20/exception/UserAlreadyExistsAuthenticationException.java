package com.colval.messenger20.exception;

import javax.naming.AuthenticationException;

public class UserAlreadyExistsAuthenticationException extends AuthenticationException {

    public UserAlreadyExistsAuthenticationException(final String msg) {
        super(msg);
    }

}
