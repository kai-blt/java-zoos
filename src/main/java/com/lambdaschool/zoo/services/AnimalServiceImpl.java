package com.lambdaschool.zoo.services;

import com.lambdaschool.zoo.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "animalService")
public class AnimalServiceImpl implements AnimalService {
    @Autowired
    private AnimalRepository animalrepos;
}
