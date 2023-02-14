package com.softuni.springintroexercises.exeptions;

@SuppressWarnings("unused")
public class NoSuchBookFoundException extends BookAppException {

    public NoSuchBookFoundException() {
        super();
    }

    public NoSuchBookFoundException(Throwable cause) {
        super(cause);
    }

    public NoSuchBookFoundException(String message) {
        super(message);
    }

    public NoSuchBookFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    protected NoSuchBookFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
