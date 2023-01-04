package com.example.demo.service;


import com.example.demo.entities.Reservation;
import com.example.demo.entities.custom.CountTourist;
import com.example.demo.entities.custom.StatusAmount;
import com.example.demo.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int reservationId){
        return reservationRepository.getReservas(reservationId);
    }

    public Reservation save(Reservation reservation){
        if(reservation.getIdReservation()==null){
            return reservationRepository.save(reservation);
        }else{
            Optional<Reservation> e= reservationRepository.getReservas(reservation.getIdReservation());
            if(e.isEmpty()){
                return reservationRepository.save(reservation);
            }else{
                return reservation;
            }
        }
    }

    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> e= reservationRepository.getReservas(reservation.getIdReservation());
            if(!e.isEmpty()){
                if(reservation.getStartDate()!=null){
                    e.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getFinishDate()!=null){
                    e.get().setFinishDate(reservation.getFinishDate());
                }
                if(reservation.getStatus()!=null){
                    e.get().setStatus(reservation.getStatus());
                }
                if(reservation.getCity()!=null){
                    e.get().setCity(reservation.getCity());
                }
                if(reservation.getTourist()!=null){
                    e.get().setTourist(reservation.getTourist());
                }

                reservationRepository.save(e.get());
                return e.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }

    public boolean deleteReservation(int reservationId){
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public List<CountTourist> getTopTourist() {
        return reservationRepository.getTopTourist();
    }

    public StatusAmount getStatusReport() {
        List<Reservation> completed = reservationRepository.getReservationsByDescription("completed");
        List<Reservation> cancelled = reservationRepository.getReservationsByDescription("cancelled");
        StatusAmount statusAmount = new StatusAmount(completed.size(), cancelled.size());
        return statusAmount;
    }

    public List<Reservation> getReservationPeriod(String startDateString, String finishDateString) {


        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = new Date();
        Date finishDate = new Date();
        try {
            startDate = parser.parse(startDateString);
            finishDate = parser.parse(finishDateString);
        } catch (ParseException e) {
        }
        if (startDate.before(finishDate)) {
            return reservationRepository.getReservationsPeriod(startDate, finishDate);
        }
        return new ArrayList<>();


    }
}
