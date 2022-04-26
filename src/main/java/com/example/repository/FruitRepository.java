package com.example.repository;

import com.example.entity.Fruit;
import io.micronaut.data.repository.CrudRepository;

public interface FruitRepository extends CrudRepository<Fruit, String> {


}
