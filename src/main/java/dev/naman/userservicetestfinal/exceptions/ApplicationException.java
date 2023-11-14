package dev.naman.userservicetestfinal.exceptions;

public class ApplicationException extends Exception{
    private String message;

    public ApplicationException(String message){
        super(message,null);
        this.message=message;
    }
}
