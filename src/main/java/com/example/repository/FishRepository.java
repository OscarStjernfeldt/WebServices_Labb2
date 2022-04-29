package com.example.repository;

import com.example.entity.Fish;
import io.micronaut.core.annotation.NonNull;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface FishRepository {

    @NonNull
    Publisher<Fish> list();

    Mono<Boolean> save(@NonNull @NotNull @Valid Fish fish);
}
