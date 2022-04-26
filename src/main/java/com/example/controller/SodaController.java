package com.example.controller;

import com.example.entity.Soda;
import com.example.service.SodaService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

import java.util.List;

@Controller("/soda")
public class SodaController {

    private SodaService sodaService;

    @Get("/getAll")
    public List<Soda> getListOfSodas() {
        return sodaService.getList();
    }

    @Post("/add")
    public void addSoda() {
        sodaService.add(new Soda("Coke"));
    }
}
