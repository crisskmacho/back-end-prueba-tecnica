package com.example.demo.repository.crudRepository;


import com.example.demo.entities.Tourist;
import org.springframework.data.repository.CrudRepository;

public interface TouristCrudRepository extends CrudRepository<Tourist, Integer> {
}
