package com.example.demo.controller;


import com.example.demo.entities.Reservation;
import com.example.demo.entities.custom.CountTourist;
import com.example.demo.entities.custom.StatusAmount;
import com.example.demo.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getAll(){
        return reservationService.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation p){
        return reservationService.save(p);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation){
        return reservationService.update(reservation);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable ("id")int id){
        return reservationService.deleteReservation(id);
    }

    @GetMapping("/report-status")
    public StatusAmount getReservationAmount(){
        return reservationService.getStatusReport();
    }

    @GetMapping("/report-tourist")
    public List<CountTourist> getCountTourist(){
        return reservationService.getTopTourist();
    }

    @GetMapping("report-dates/{startDate}/{finishDate}")
    public List<Reservation> getReservationReport(@PathVariable("startDate") String startDateString, @PathVariable("finishDate") String finishDateString) {
        return reservationService.getReservationPeriod(startDateString, finishDateString);
    }
}
