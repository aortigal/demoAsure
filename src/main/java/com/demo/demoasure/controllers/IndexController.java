package com.demo.demoasure.controllers;

import com.demo.demoasure.models.Demo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
public class IndexController {

    @RequestMapping("/")
    public Mono<String> index() {
        return Mono.just("Bienvenido! Amado David Ortiz Gallardo");
    }

    @RequestMapping("/demo")
    public Flux<Demo> demo() {

       Flux<Demo> demos= Flux.just(new Demo("TV Panasonic Pantalla LCD", 456.89,"TV Panasonic Pantalla LCD"),
                new Demo("Sony Camara HD Digital", 177.89,"Sony Camara HD Digital"),
                new Demo("Apple iPod", 46.89,"Apple iPod"),
                new Demo("Sony Notebook", 846.89,"Sony Notebook"),
                new Demo("Hewlett Packard Multifuncional", 200.89,"Hewlett Packard Multifuncional"),
                new Demo("Bianchi Bicicleta", 70.89,"Bianchi Bicicleta"),
                new Demo("HP Notebook Omen 17", 2500.89,"HP Notebook Omen 17"),
                new Demo("Mica Cómoda 5 Cajones", 150.89,"Mica Cómoda 5 Cajones"),
                new Demo("TV Sony Bravia OLED 4K Ultra HD", 2255.89,"TV Sony Bravia OLED 4K Ultra HD"))
               .map(x -> {
                   x.setName(x.getName().toUpperCase());
                    return x;
                    }
               ).repeat(100);

       demos.subscribe(System.out::println);
        return demos;
    }
}
