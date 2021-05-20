package com.example.projetfinal.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ReservationDate {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne()
    @JoinColumn(name = "id_reservation")
    private Reservation reservation;
    private Date date;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public ReservationDate(Reservation reservation, Date date) {
        this.reservation = reservation;
        this.date = date;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
