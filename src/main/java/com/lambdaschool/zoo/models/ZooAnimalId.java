package com.lambdaschool.zoo.models;

import javax.persistence.Embeddable;
import java.io.Serializable;


@Embeddable
public class ZooAnimalId  implements Serializable {
    private long zoo;
    private long animal;

    //Constructor
    public ZooAnimalId() {
        //default constructor for jpa
    }

    public ZooAnimalId(long zoo, long animal) {
        this.zoo = zoo;
        this.animal = animal;
    }

    //Getters&Setters
    public long getZoo() {
        return zoo;
    }

    public void setZoo(long zoo) {
        this.zoo = zoo;
    }

    public long getAnimal() {
        return animal;
    }

    public void setAnimal(long animal) {
        this.animal = animal;
    }


    //Equals and Hashcode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZooAnimalId that = (ZooAnimalId) o;
        return getZoo() == that.getZoo() &&
                getAnimal() == that.getAnimal();
    }

    @Override
    public int hashCode() {
        return 42;
    }
}
