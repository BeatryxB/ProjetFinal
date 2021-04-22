package com.example.projetfinal.Entity;

import javax.persistence.*;

@Entity
public class Event {

    @Id
    @GeneratedValue
    private Long idEvent;
    @ManyToOne(cascade = {CascadeType.ALL})
    private Type type;
    private String titre;
    private String description;
    private String date;
    private String localisation;

    public Event(String titre, String description, Type type, String date, String localisation) {
        this.titre = titre;
        this.description = description;
        this.type = type;
        this.date = date;
        this.localisation = localisation;
    }

    public Event() {

    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public void setIdEvent(Long id) {
        this.idEvent = id;
    }

    public Long getIdEvent() {
        return idEvent;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + idEvent +
                ", titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", date='" + date + '\'' +
                ", localisation='" + localisation + '\'' +
                '}';
    }
}
