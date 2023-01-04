package com.example.demo.repository;


import com.example.demo.entities.Tourist;
import com.example.demo.repository.crudRepository.TouristCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TouristRepository {

    @Autowired
    private TouristCrudRepository touristCrudRepository;

    public Optional<Tourist> getTourist(int id){
        return touristCrudRepository.findById(id);
    }

    public Tourist save(Tourist tourist){
        return touristCrudRepository.save(tourist);
    }

    public void delete(Tourist tourist){
        touristCrudRepository.delete(tourist);
    }

    public List<Tourist> getAll(){
        return (List<Tourist>) touristCrudRepository.findAll();
    }

}
