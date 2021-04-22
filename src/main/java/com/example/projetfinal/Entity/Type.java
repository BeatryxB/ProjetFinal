package com.example.projetfinal.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Type {
    @Id
    @GeneratedValue
    private Long id;
    private String typeField;

    public Type() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getTypeField() {
        return typeField;
    }

    public void setTypeField(String typeField) {
        this.typeField = typeField;
    }

    public Type(String typeField) {
        this.typeField = typeField;
    }

    @Override
    public String toString() {
        return "Type{" +
                "TypeField='" + typeField + '\'' +
                '}';
    }

}
