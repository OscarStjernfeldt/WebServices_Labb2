package com.example.service;

import com.example.entity.Fruit;
import jakarta.inject.Singleton;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class FruitService {

    private final List<Fruit> fruitList = new ArrayList<>();

    public void addFruit(Fruit fruit) {
        fruitList.add(fruit);
    }

    public List<Fruit> getFruitList() {
        return fruitList;
    }
}
