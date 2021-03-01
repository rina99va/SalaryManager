package com.salary.manager.exceptions;

public class UnitNotFoundException extends RuntimeException {
    public UnitNotFoundException(final String id) {
        super(String.format("Unit with id %s not found", id));
    }
}
