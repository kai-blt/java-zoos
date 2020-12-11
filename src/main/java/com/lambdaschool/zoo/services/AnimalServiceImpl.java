package com.lambdaschool.zoo.services;

import com.lambdaschool.zoo.repositories.AnimalRepository;
import com.lambdaschool.zoo.views.AnimalCountZoo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "animalService")
public class AnimalServiceImpl implements AnimalService {
    @Autowired
    private AnimalRepository animalrepos;

    @Override
    public List<AnimalCountZoo> getZooCount() {
        return animalrepos.getZooCount();
    }
}
