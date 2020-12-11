package com.lambdaschool.zoo.services;

import com.lambdaschool.zoo.models.Zoo;

import java.util.List;

public interface ZooService {
    List<Zoo> getAllZoos();

    Zoo findById(long zooid);

    Zoo save(Zoo zoo);

    Zoo update(Zoo zoo, long zooid);

    void delete(long zooid);
}
