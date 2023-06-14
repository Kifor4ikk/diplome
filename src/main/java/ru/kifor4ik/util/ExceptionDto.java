package ru.kifor4ik.util;

public class ExceptionDto extends Exception{

    private String message;
    private String cause;

    public ExceptionDto(String message, String cause) {
        super(message);
        this.message = message;
        this.cause = cause;
    }

    @Override
    public String toString() {
        return "ExceptionDto{" +
                "message='" + message + '\'' +
                ", cause='" + cause + '\'' +
                '}';
    }
}
