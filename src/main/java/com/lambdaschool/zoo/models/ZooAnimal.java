package com.lambdaschool.zoo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "zooanimals")
@IdClass(ZooAnimalId.class)
public class ZooAnimal extends Auditable implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "zooid")
    @JsonIgnoreProperties(value = "animal", allowSetters = true)
    private Zoo zoo;

    @Id
    @ManyToOne
    @JoinColumn(name = "animalid")
    @JsonIgnoreProperties(value = "zoo", allowSetters = true)
    private Animal animal;

    private String incomingzoo;

    //Constructors
    public ZooAnimal() {
        //jpa constructor
    }


    public ZooAnimal(String incomingzoo) {
        this.incomingzoo = incomingzoo;
    }

    public ZooAnimal(Zoo zoo, Animal animal) {
        this.zoo = zoo;
        this.animal = animal;
    }


    public Zoo getZoo() {
        return zoo;
    }

    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public String getIncomingzoo() {
        return incomingzoo;
    }

    public void setIncomingzoo(String incomingzoo) {
        this.incomingzoo = incomingzoo;
    }

    @Override
    public boolean equals(Object o) {
        //If this object IS this object, then they are equal, return true
        if (this == o) return true;

        //If this object IS not of the same TYPE as THAT object
        //Then they are NOT equal, return false
        if (!(o instanceof ZooAnimal)) return false;

        //If we've reached this point, the object is indeed of the composite type that we know of.
        //Typecast the object to the type we know
        ZooAnimal that = (ZooAnimal) o;

        //Compare the two fields on both tables. We have to account for the fields being NULL
        //If null set to 0 and let JPA handle
        return ((zoo == null) ? 0 : zoo.getZooid()) == ((that.zoo == null) ? 0 : that.zoo.getZooid()) &&
                ((animal == null) ? 0 : animal.getAnimalid()) == ((that.animal == null) ? 0 : that.animal.getAnimalid());
    }


    @Override
    public int hashCode() {
        return 37;
    }

}
