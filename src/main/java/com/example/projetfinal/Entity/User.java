package com.example.projetfinal.Entity;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class User {

    @javax.persistence.Id
    @GeneratedValue
    private @Id
    Long idUser;
    private String pseudo;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private boolean handicap;
    private String gender;
    private String password;

    public User(String pseudo, String firstName, String lastName, String dateOfBirth, boolean handicap, String gender, String password) {
        this.pseudo = pseudo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.handicap = handicap;
        this.gender = gender;
        this.password = password;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isHandicap() {
        return handicap;
    }

    public void setHandicap(boolean handicap) {
        this.handicap = handicap;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {

    }

    public void setIdUser(Long id) {
        this.idUser = id;
    }

    public Long getIdUser() {
        return idUser;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + idUser +
                ", Pseudo='" + pseudo + '\'' +
                ", FirstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", handicap=" + handicap +
                ", gender='" + gender + '\'' +
                '}';
    }
}
