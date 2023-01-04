package com.example.demo.repository;


import com.example.demo.entities.Reservation;
import com.example.demo.entities.Tourist;
import com.example.demo.entities.custom.CountTourist;
import com.example.demo.repository.crudRepository.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {


    @Autowired
    private ReservationCrudRepository reservationCrudRepository;


    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }

    public Optional<Reservation> getReservas(int id){
        return reservationCrudRepository.findById(id);
    }

    public Reservation save(Reservation reservation){
        return reservationCrudRepository.save(reservation);
    }

    public void delete(Reservation reservation){
        reservationCrudRepository.delete(reservation);
    }

    public List<Reservation> getReservationsByDescription(String description){
        return reservationCrudRepository.findAllByDescription(description);
    }

    public List<Reservation> getReservationsPeriod(Date dateOne, Date dateTwo){
        return  reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(dateOne, dateTwo);
    }

    public List<CountTourist> getTopTourist (){
        List<CountTourist> res=new ArrayList<>();

        List<Object[]> report=reservationCrudRepository.countTotalReservationByTourist();
        for(int i=0; i<report.size(); i++){
            res.add(new CountTourist((Integer) report.get(i)[1],(Tourist)report.get(i)[0]));
        }

        return res;
    }
}
