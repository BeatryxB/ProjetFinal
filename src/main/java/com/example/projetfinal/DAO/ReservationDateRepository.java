package com.example.projetfinal.DAO;

import com.example.projetfinal.Entity.Reservation;
import com.example.projetfinal.Entity.ReservationDate;
import com.example.projetfinal.Entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReservationDateRepository extends CrudRepository<ReservationDate, Long> {
    //public int countReservationDateByDateMonth(int Month);
    //public int countReservationDateByDateDay(int Day);
    //public int countReservationDateByDateYear(int Month);
}
