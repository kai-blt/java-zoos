package com.lambdaschool.zoo.models;

import javax.persistence.Embeddable;
import java.io.Serializable;


@Embeddable
public class ZooAnimalId extends Auditable implements Serializable {
    private long zoo;
    private long animal;

    //Constructor
    public ZooAnimalId() {
        //default constructor for jpa
    }

    //Getters&Setters
    public long getZooid() {
        return zoo;
    }

    public void setZooid(long zoo) {
        this.zoo = zoo;
    }

    public long getAnimalid() {
        return animal;
    }

    public void setAnimalid(long animal) {
        this.animal = animal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZooAnimalId that = (ZooAnimalId) o;
        return getZooid() == that.getZooid() &&
                getAnimalid() == that.getAnimalid();
    }

    @Override
    public int hashCode() {
        return 37;
    }
}
