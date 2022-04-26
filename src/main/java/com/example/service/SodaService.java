package com.example.service;

import com.example.entity.Soda;
import jakarta.inject.Singleton;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class SodaService {

    private final List<Soda> sodaList = new ArrayList<>();

    private Soda createSoda(String soda) {
        return new Soda(soda);
    }
}
