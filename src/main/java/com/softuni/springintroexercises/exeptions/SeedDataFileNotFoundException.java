package com.softuni.springintroexercises.exeptions;

@SuppressWarnings("unused")
public class SeedDataFileNotFoundException extends BookAppException {

    public SeedDataFileNotFoundException() {
        super();
    }

    public SeedDataFileNotFoundException(Throwable cause) {
        super(cause);
    }

    public SeedDataFileNotFoundException(String message) {
        super(message);
    }

    public SeedDataFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    protected SeedDataFileNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
