package com.example.controller;

import com.example.entity.Fish;
import com.example.repository.FishRepository;
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

@Controller("/fishes")
class FishController {

    private final FishRepository fishService;

    FishController(FishRepository fishService) {
        this.fishService = fishService;
    }

    @Get
    Publisher<Fish> list() {
        return fishService.list();
    }

    @Post
    Mono<HttpStatus> save(@NonNull @NotNull @Valid Fish fish) {
        return fishService.save(fish)
                .map(added -> added ? CREATED : CONFLICT);
    }
}
