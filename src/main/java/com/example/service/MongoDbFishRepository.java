package com.example.service;

import com.example.entity.Fish;
import com.example.repository.FishRepository;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoCollection;
import io.micronaut.core.annotation.NonNull;
import jakarta.inject.Singleton;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Singleton
public class MongoDbFishRepository implements FishRepository {

    private final MongoClient mongoClient;

    public MongoDbFishRepository(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    @Override
    public Mono<Boolean> save(@NonNull @NotNull @Valid Fish fish) {
        return Mono.from(getCollection().insertOne(fish))
                .map(insertOneResult -> true)
                .onErrorReturn(false);
    }

    @Override
    @NonNull
    public Publisher<Fish> list() {
        return getCollection().find();
    }

    @NonNull
    private MongoCollection<Fish> getCollection() {
        return mongoClient.getDatabase("db2")
                .getCollection("fish", Fish.class);
    }
}
