package com.example.demo.controller;


import com.example.demo.entities.Tourist;
import com.example.demo.service.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/Tourist")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class TouristController {

    @Autowired
    private TouristService touristService;


    @GetMapping("/all")
    public List<Tourist> getAll(){
        return touristService.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Tourist save(@RequestBody Tourist t){
        return touristService.save(t);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Tourist update(@RequestBody Tourist tourist){
        return touristService.update(tourist);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable ("id")int id){
        return touristService.deleteTourist(id);
    }
}
