package com.example.projetfinal.Entity;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Reservation {
    @Id
    @GeneratedValue
    private Long idReservation;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    private Event event;
    private boolean payee;

    public Reservation(User user, Event event) {
        this.user = user;
        this.event= event;
        this.payee = false;
    }

    public Reservation() {

    }

    public void setIdReservation(Long id) {
        this.idReservation = id;
    }

    public Long getIdReservation() {
        return idReservation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public boolean isPayee() {
        return payee;
    }

    public void setPayee(boolean payee) {
        this.payee = payee;
    }
}
