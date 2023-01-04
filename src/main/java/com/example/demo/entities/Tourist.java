package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;



import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "turista")
public class Tourist implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTourist;
    private String nombreCompleto;
    private Date fechaDeNacimiento;
    private String identificacion;
    private String tipoDeIdentificacion;
    private Integer frecuenciaViaje;
    private Double presupuestoViaje;
    private String nombreCiudad;
    private Boolean tarjetaCredito;


    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "tourist")
    @JsonIgnoreProperties("tourist")
    private List<City> cities;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "tourist")
    @JsonIgnoreProperties("tourist")
    private List<Reservation> reservations;


    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Integer getIdTourist() {
        return idTourist;
    }

    public void setIdTourist(Integer idTourist) {
        this.idTourist = idTourist;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Date fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getTipoDeIdentificacion() {
        return tipoDeIdentificacion;
    }

    public void setTipoDeIdentificacion(String tipoDeIdentificacion) {
        this.tipoDeIdentificacion = tipoDeIdentificacion;
    }

    public Integer getFrecuenciaViaje() {
        return frecuenciaViaje;
    }

    public void setFrecuenciaViaje(Integer frecuenciaViaje) {
        this.frecuenciaViaje = frecuenciaViaje;
    }

    public Double getPresupuestoViaje() {
        return presupuestoViaje;
    }

    public void setPresupuestoViaje(Double presupuestoViaje) {
        this.presupuestoViaje = presupuestoViaje;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public Boolean getTarjetaCredito() {
        return tarjetaCredito;
    }

    public void setTarjetaCredito(Boolean tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }


    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public List<City> getCities() {
        return cities;
    }
}
