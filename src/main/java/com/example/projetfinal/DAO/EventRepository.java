package com.example.projetfinal.DAO;

import com.example.projetfinal.Entity.Event;
import com.example.projetfinal.Entity.Reservation;
import com.example.projetfinal.Entity.Type;
import com.example.projetfinal.Entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventRepository extends CrudRepository<Event, Long> {
    public Event getEventByIdEvent(Long idEvent);
    //titre seul
    public List<Event> getEventsByTitreIsContaining(String titre);
    //date seul
    public List<Event> getEventsByDate(String date);
    //Loc seul
    public List<Event> getEventsByLocalisationIsContaining(String loc);
    //type seul
    public List<Event> getEventsByType(Type type);

    public List<Event> getEventsByDateAndTitreIsContaining(String date, String title);
    public List<Event> getEventsByDateAndType(String date, Type type);
    public List<Event> getEventsByDateAndLocalisationIsContaining(String date, String loc);

    public List<Event> getEventsByTitreIsContainingAndLocalisationIsContaining(String title, String loc);
    public List<Event> getEventsByLocalisationIsContainingAndType(String loc, Type type);

    public List<Event> getEventsByTitreIsContainingAndType(String title, Type type);

    public List<Event> getEventsByDateAndTypeAndLocalisationIsContaining(String date, Type type, String loc);
    public List<Event> getEventsByDateAndTypeAndTitreIsContaining(String date, Type type, String title);
    public List<Event> getEventsByTitreIsContainingAndDateAndLocalisationContaining(String title, String date, String loc);
    public List<Event> getEventsByTitreIsContainingAndTypeAndLocalisationContaining(String title, Type type, String loc);
    public List<Event> getEventsByDateAndTypeAndTitreIsContainingAndLocalisationIsContaining(String date, Type type, String title, String loc);


}
