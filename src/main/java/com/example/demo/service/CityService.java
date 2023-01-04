package com.example.demo.service;


import com.example.demo.entities.City;
import com.example.demo.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    @Autowired
    public CityRepository cityRepository;


    public List<City> getAll(){
        return cityRepository.getAll();
    }

    public Optional<City> getCity(int id){
        return cityRepository.getCity(id);
    }

    public City save(City c){
        if(c.getIdCity()==null){
            return cityRepository.save(c);
        }else{
            Optional<City> e=cityRepository.getCity(c.getIdCity());
            if(e.isPresent()){
                return c;
            }else{
                return cityRepository.save(c);
            }
        }
    }

    public City update(City c) {
        if (c.getIdCity() != null) {
            Optional<City> q = cityRepository.getCity(c.getIdCity());
            if (q.isPresent()) {
                if (c.getNombreCiudad() != null) {
                    q.get().setNombreCiudad(c.getNombreCiudad());
                }
                if (c.getCantidadHabitantes() != null) {
                    q.get().setCantidadHabitantes(c.getCantidadHabitantes());
                }
                if (c.getSitioMasTuristico() != null) {
                    q.get().setSitioMasTuristico(c.getSitioMasTuristico());
                }
                if (c.getHotelMasReservado() != null) {
                    q.get().setHotelMasReservado(c.getHotelMasReservado());
                }
                if (c.getTourist() != null) {
                    q.get().setTourist(c.getTourist());
                }
                if (c.getReservations() != null) {
                    q.get().setReservations(c.getReservations());
                }

                cityRepository.save(q.get());
                return q.get();
            } else {
                return c;
            }
        }else{
            return c;
        }
    }

    public boolean delete(int id){
        boolean flag=false;
        Optional<City>c=cityRepository.getCity(id);
        if(c.isPresent()){
            cityRepository.delete(c.get());
            flag=true;
        }
        return flag;
    }
}
