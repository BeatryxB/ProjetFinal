package com.example.projetfinal.Entity;

import com.example.projetfinal.DAO.EventRepository;
import com.example.projetfinal.DAO.ReservationRepository;
import com.example.projetfinal.DAO.TypeRepository;
import com.example.projetfinal.DAO.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Loader implements CommandLineRunner {
    private final UserRepository userRepository;
    private final TypeRepository typeRepository;
    private EventRepository eventRepository;
    private final ReservationRepository reservationRepository;

    @Autowired
    public Loader(UserRepository userRepository, TypeRepository typeRepository, EventRepository eventRepository, ReservationRepository reservationRepository){
        this.userRepository = userRepository;
        this.typeRepository = typeRepository;
        this.eventRepository = eventRepository;
        this.reservationRepository = reservationRepository;
    }
    @Override
    public void run(String... strings)throws Exception {
        User u = new User("pseudo","jean", "Dupont", "1998-08-17", "Male","pass");
        Type t = new Type("Concert");
        Event e = new Event("Concert","Music Concert",t,"2020-01-12","21:00","Church");
        Event e2 = new Event("Concert2","Music Concert2",t,"2021-01-12","20:00","Church");
        this.userRepository.save(u);
        this.typeRepository.save(t);
        this.eventRepository.save(e);
        this.eventRepository.save(e2);
        this.reservationRepository.save(new Reservation(u,e));
        this.reservationRepository.save(new Reservation(u,e2));
    }
}
