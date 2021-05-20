package com.example.projetfinal.DAO;

import com.example.projetfinal.Entity.Event;
import com.example.projetfinal.Entity.Tarif;
import org.springframework.data.repository.CrudRepository;

public interface TarifRepository extends CrudRepository<Tarif, Long> {

    public Tarif getReservationByTarif(Tarif tarif);

}
