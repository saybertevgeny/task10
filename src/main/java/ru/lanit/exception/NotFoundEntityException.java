package ru.lanit.exception;

public class NotFoundEntityException extends Exception {

    private final String message = "Сущность не найдена";

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString(){
        return message;
    }
}
