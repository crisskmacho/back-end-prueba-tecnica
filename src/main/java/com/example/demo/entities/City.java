package com.example.demo.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "city")
public class City implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCity;
    private String nombreCiudad;
    private Integer cantidadHabitantes;
    private String sitioMasTuristico;
    private String hotelMasReservado;

    @ManyToOne()
    @JoinColumn(name = "idTourist")
    @JsonIgnoreProperties({"cities"})
    private Tourist tourist;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "city")
    @JsonIgnoreProperties("city")
    private List<Reservation> reservations;


    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }


    public Tourist getTourist() {
        return tourist;
    }

    public void setTourist(Tourist tourist) {
        this.tourist = tourist;
    }

    public Integer getIdCity() {
        return idCity;
    }

    public void setIdCity(Integer idCity) {
        this.idCity = idCity;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public Integer getCantidadHabitantes() {
        return cantidadHabitantes;
    }

    public void setCantidadHabitantes(Integer cantidadHabitantes) {
        this.cantidadHabitantes = cantidadHabitantes;
    }

    public String getSitioMasTuristico() {
        return sitioMasTuristico;
    }

    public void setSitioMasTuristico(String sitioMasTuristico) {
        this.sitioMasTuristico = sitioMasTuristico;
    }

    public String getHotelMasReservado() {
        return hotelMasReservado;
    }

    public void setHotelMasReservado(String hotelMasReservado) {
        this.hotelMasReservado = hotelMasReservado;
    }
}
