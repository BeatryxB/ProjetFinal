package com.example.projetfinal.Entity;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.util.Date;

@Entity
public class User {

    @javax.persistence.Id
    @GeneratedValue
    private @Id
    Long id;
    private String FirstName;
    private String lastName;
    private String dateOfBirth;
    private boolean handicap;
    private String gender;

    public User(String firstName, String lastName, String dateOfBirth, boolean handicap, String gender) {
        FirstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.handicap = handicap;
        this.gender = gender;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
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

    public User() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    /*@Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", FirstName='" + FirstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", handicap=" + handicap +
                ", gender='" + gender + '\'' +
                '}';
    }*/
}
