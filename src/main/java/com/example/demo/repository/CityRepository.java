package com.example.demo.repository;


import com.example.demo.entities.City;
import com.example.demo.repository.crudRepository.CityCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CityRepository {

    @Autowired
    private CityCrudRepository cityCrudRepository;

    public Optional<City> getCity(int id){
        return cityCrudRepository.findById(id);
    }

    public City save(City city){
        return cityCrudRepository.save(city);
    }

    public void delete(City city){
        cityCrudRepository.delete(city);
    }

    public List<City> getAll(){
        return (List<City>) cityCrudRepository.findAll();
    }
}
