package com.lambdaschool.zoo.models;

import javax.persistence.*;

@Entity
@Table(name = "animals")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long animalid;
    private String animaltype;

    //Constructors
    public Animal() {
    }

    public Animal(long animalid, String animaltype) {
        this.animalid = animalid;
        this.animaltype = animaltype;
    }

    //Getters&Setters
    public long getAnimalid() {
        return animalid;
    }

    public void setAnimalid(long animalid) {
        this.animalid = animalid;
    }

    public String getAnimaltype() {
        return animaltype;
    }

    public void setAnimaltype(String animaltype) {
        this.animaltype = animaltype;
    }
}
