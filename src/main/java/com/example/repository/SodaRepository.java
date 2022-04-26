package com.example.repository;

import com.example.entity.Soda;
import io.micronaut.context.annotation.Executable;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface SodaRepository extends CrudRepository<Soda, String> {
    @Executable
    Soda find(Soda soda);
}
