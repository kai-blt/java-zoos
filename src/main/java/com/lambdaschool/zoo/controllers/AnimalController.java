package com.lambdaschool.zoo.controllers;

import com.lambdaschool.zoo.models.Animal;
import com.lambdaschool.zoo.services.AnimalService;
import com.lambdaschool.zoo.views.AnimalCountZoo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {
    @Autowired
    AnimalService animalServices;

    // http://localhost:2019/animals/count
    @GetMapping(value = "/count", produces = "application/json")
    public ResponseEntity<?> getZooCount() {
        List<AnimalCountZoo> zooCount = animalServices.getZooCount();
        return new ResponseEntity<>(zooCount, HttpStatus.OK);
    }

}
