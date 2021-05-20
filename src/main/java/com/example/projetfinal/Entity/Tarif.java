package com.example.projetfinal.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Tarif {

    @Id
    @GeneratedValue
    Long id;
    private String libelle;
    private float tarif;
    private int ageMin;
    private int ageMax;


    public Tarif(Long idTarif, String libelle, float tarif, int ageMin, int ageMax)
    {
        this.id = idTarif;
        this.libelle = libelle;
        this.tarif = tarif;
        this.ageMax = ageMax;
        this.ageMin = ageMin;

    }

    public Tarif() { }

    public float getTarif() { return tarif; }
    public int getAgeMax() { return ageMax; }
    public int getAgeMin() { return ageMin; }
    public Long getId() { return id; }
    public String getLibelle() { return libelle; }

    public void setAgeMax(int ageMax) { this.ageMax = ageMax; }
    public void setAgeMin(int ageMin) { this.ageMin = ageMin; }
    public void setId(Long idTarif) { this.id = idTarif; }
    public void setLibelle(String libelle) { this.libelle = libelle; }
    public void setTarif(float tarif) { this.tarif = tarif; }
}
// rtest