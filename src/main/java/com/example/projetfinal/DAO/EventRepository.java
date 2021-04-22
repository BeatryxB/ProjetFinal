package com.example.projetfinal.DAO;

import com.example.projetfinal.Entity.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long> {
}
