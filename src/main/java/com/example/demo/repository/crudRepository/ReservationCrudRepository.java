package com.example.demo.repository.crudRepository;

import com.example.demo.entities.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {

    @Query("SELECT c.tourist, COUNT(c.tourist) FROM Reservation AS c GROUP BY c.tourist ORDER BY COUNT(c.tourist) DESC")
    public List<Object[]>countTotalReservationByTourist();

    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);

    public List<Reservation> findAllByDescription(String description);
}
