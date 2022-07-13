package com.example.examplewebflux;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

import java.net.URI;


@Component
public class GreetingHandler {

    @Autowired
    private GreetingRepository repository;

    public Mono<ServerResponse> hello(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(new Greeting("Hello, Spring!")));
    }

    public Mono<ServerResponse> createGreeting(ServerRequest request) {
        Mono<Greeting> greeting = request.bodyToMono(Greeting.class);
        return greeting.flatMap(g -> {
            return repository.save(g).flatMap(gdb -> ServerResponse
                    .created(URI.create("/greetings"))
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(BodyInserters.fromValue(gdb)));
        });
    }
}