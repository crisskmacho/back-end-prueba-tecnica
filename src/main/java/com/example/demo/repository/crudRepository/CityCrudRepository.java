package com.example.demo.repository.crudRepository;

import com.example.demo.entities.City;
import org.springframework.data.repository.CrudRepository;

public interface CityCrudRepository extends CrudRepository<City, Integer> {
}
