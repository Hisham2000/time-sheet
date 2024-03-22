package com.example.Back.handler;

public class PreventSaveException extends Exception{

    private String key;
    private String message;

    public PreventSaveException() {
    }

    public PreventSaveException(String key , String message) {
        super(message);
        this.key = key;
        this.message = message;
    }

    public PreventSaveException(String message) {
        super(message);
        this.message = message;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}

