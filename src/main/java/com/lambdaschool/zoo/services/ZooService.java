package com.lambdaschool.zoo.services;

import com.lambdaschool.zoo.models.Zoo;

import java.util.List;

public interface ZooService {
    List<Zoo> getAllZoos();

    Zoo findById(long zooid);
}
