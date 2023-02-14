package com.softuni.springintroexercises.exeptions;

@SuppressWarnings("unused")
public abstract class BookAppException extends RuntimeException {

    public BookAppException() {
        super();
    }

    public BookAppException(Throwable cause) {
        super(cause);
    }

    public BookAppException(String message) {
        super(message);
    }

    public BookAppException(String message, Throwable cause) {
        super(message, cause);
    }

    protected BookAppException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
