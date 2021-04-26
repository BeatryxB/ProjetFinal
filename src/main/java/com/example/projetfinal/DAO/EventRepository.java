package com.example.projetfinal.DAO;

import com.example.projetfinal.Entity.Event;
import com.example.projetfinal.Entity.Reservation;
import com.example.projetfinal.Entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventRepository extends CrudRepository<Event, Long> {
    public Event getEventByIdEvent(Long idEvent);

}
