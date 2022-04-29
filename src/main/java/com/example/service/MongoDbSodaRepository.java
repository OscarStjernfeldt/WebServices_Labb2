package com.example.service;

import com.example.entity.Soda;
import com.example.repository.SodaRepository;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoCollection;
import io.micronaut.core.annotation.NonNull;
import jakarta.inject.Singleton;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Singleton
public class MongoDbSodaRepository implements SodaRepository {

    private final MongoClient mongoClient;

    public MongoDbSodaRepository(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    @Override
    public Mono<Boolean> save(@NonNull @NotNull @Valid Soda soda) {
        return Mono.from(getCollection().insertOne(soda))
                .map(insertOneResult -> true)
                .onErrorReturn(false);
    }

    @Override
    @NonNull
    public Publisher<Soda> list() {
        return getCollection().find();
    }

    @NonNull
    private MongoCollection<Soda> getCollection() {
        return mongoClient.getDatabase("db1")
                .getCollection("soda", Soda.class);
    }
}
