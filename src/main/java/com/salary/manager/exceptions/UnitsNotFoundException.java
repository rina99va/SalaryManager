package com.salary.manager.exceptions;

public class UnitsNotFoundException extends RuntimeException{
    public UnitsNotFoundException(){
        super("Units not found");
    }
}
