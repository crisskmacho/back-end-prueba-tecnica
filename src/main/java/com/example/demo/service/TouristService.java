package com.example.demo.service;


import com.example.demo.entities.Tourist;
import com.example.demo.repository.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TouristService {

    @Autowired
    private TouristRepository touristRepository;

    public List<Tourist> getAll(){
        return touristRepository.getAll();
    }

    public Optional<Tourist> getClient(int touristId){
        return touristRepository.getTourist(touristId);
    }

    public Tourist save(Tourist tourist){
        if(tourist.getIdTourist()==null){
            return touristRepository.save(tourist);
        }else{
            Optional<Tourist> e=touristRepository.getTourist(tourist.getIdTourist());
            if(e.isPresent()){
                return tourist;
            }else{
                return touristRepository.save(tourist);
            }
        }
    }

    public Tourist update(Tourist tourist){
        if(tourist.getIdTourist()!=null){
            Optional<Tourist> e=touristRepository.getTourist(tourist.getIdTourist());
            if(!e.isEmpty()) {
                if (tourist.getNombreCompleto() != null) {
                    e.get().setNombreCompleto(tourist.getNombreCompleto());
                }
                if (tourist.getFechaDeNacimiento() != null) {
                    e.get().setFechaDeNacimiento(tourist.getFechaDeNacimiento());
                }
                if (tourist.getIdentificacion() != null) {
                    e.get().setIdentificacion(tourist.getIdentificacion());
                }
                if (tourist.getTipoDeIdentificacion() != null) {
                    e.get().setTipoDeIdentificacion(tourist.getTipoDeIdentificacion());
                }
                if (tourist.getFrecuenciaViaje() != null){
                    e.get().setFrecuenciaViaje(tourist.getFrecuenciaViaje());
                }
                if (tourist.getPresupuestoViaje() != null){
                    e.get().setPresupuestoViaje(tourist.getPresupuestoViaje());
                }
                if (tourist.getNombreCiudad() != null){
                    e.get().setNombreCiudad(tourist.getNombreCiudad());
                }
                if (tourist.getTarjetaCredito() != null){
                    e.get().setTarjetaCredito(tourist.getTarjetaCredito());
                }
                if (tourist.getCities() != null){
                    e.get().setCities(tourist.getCities());
                }
                if (tourist.getReservations() != null){
                    e.get().setReservations(tourist.getReservations());
                }

            }
            touristRepository.save(e.get());
            return e.get();
        }else{
            return tourist;
        }
    }

    public boolean deleteTourist(int touristId){
        Boolean aBoolean = getClient(touristId).map(tourist -> {
            touristRepository.delete(tourist);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}

