package com.example.examplewebflux;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "greetings")
public class Greeting {

    private String id;
    private String message;

    public Greeting() {
    }
    public Greeting(String message) {
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Greeting{" +
                "message='" + message + '\'' +
                '}';
    }
}