package com.example.controller;

import com.example.entity.Soda;
import com.example.repository.SodaRepository;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import static io.micronaut.http.HttpStatus.CONFLICT;
import static io.micronaut.http.HttpStatus.CREATED;

@Controller("/sodas")
public class SodaController {

    private final SodaRepository sodaService;

    SodaController(SodaRepository sodaService) {
        this.sodaService = sodaService;
    }

    @Get
    Publisher<Soda> list() {
        return sodaService.list();
    }

    @Post
    Mono<HttpStatus> save(@NonNull @NotNull @Valid Soda soda) {
        return sodaService.save(soda)
                .map(added -> added ? CREATED : CONFLICT);
    }
}
