package com.example.repository;

import com.example.entity.Soda;
import com.mongodb.lang.NonNull;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface SodaRepository {

    @NonNull
    Publisher<Soda> list();

    Mono<Boolean> save(@NonNull @NotNull @Valid Soda fruit);
}
