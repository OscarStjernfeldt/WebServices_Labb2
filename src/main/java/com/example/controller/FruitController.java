package com.example.controller;

import com.example.entity.Fruit;
import com.example.service.FruitService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

import java.util.List;

@Controller("/fruit")
public class FruitController {

    private FruitService fruitService;

    @Get("/getAll")
    public List<Fruit> getListOfFruit() {
        return fruitService.getFruitList();
    }

    @Post("/add")
    public void addFruit() {
        fruitService.addFruit(new Fruit("Cherry"));
    }


}
