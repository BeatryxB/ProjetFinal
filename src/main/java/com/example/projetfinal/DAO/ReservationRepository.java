package com.example.projetfinal.DAO;

import com.example.projetfinal.Entity.Event;
import com.example.projetfinal.Entity.Reservation;
import com.example.projetfinal.Entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    public Event getReservationByUser(User user);
}
