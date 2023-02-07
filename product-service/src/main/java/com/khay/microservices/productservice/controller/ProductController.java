package com.khay.microservices.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping
    public String test(){
        Mono<String> response = webClientBuilder.build().get()
                .uri("http://order-service/api/orders")
                .retrieve()
                .bodyToMono(String.class);
        response.subscribe(System.out::println);
        return "returned";
    }
}
