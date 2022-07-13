package com.example.examplewebflux;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface GreetingRepository extends ReactiveCrudRepository<Greeting, String> {

}
