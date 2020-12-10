package com.lambdaschool.zoo.controllers;

import com.lambdaschool.zoo.models.Zoo;
import com.lambdaschool.zoo.services.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/zoos")
public class ZooController {

    @Autowired
    ZooService zooService;

    // http://localhost:2019/zoos/zoos
    @GetMapping(value = "/zoos", produces = "application/json")
    public ResponseEntity<?> getAllZoos() {
        List<Zoo> zooList = zooService.getAllZoos();
        return new ResponseEntity<>(zooList, HttpStatus.OK);
    }
}
