package com.twu.biblioteca.exception;

public class AccountNotExistExcepetion extends RuntimeException {
    public AccountNotExistExcepetion() {
    }

    public AccountNotExistExcepetion(String message) {
        super(message);
    }

    public AccountNotExistExcepetion(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountNotExistExcepetion(Throwable cause) {
        super(cause);
    }

    public AccountNotExistExcepetion(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
