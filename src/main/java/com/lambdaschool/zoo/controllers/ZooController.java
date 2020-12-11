package com.lambdaschool.zoo.controllers;

import com.lambdaschool.zoo.models.Zoo;
import com.lambdaschool.zoo.services.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/zoos")
public class ZooController {

    @Autowired
    ZooService zooService;

    // GET http://localhost:2019/zoos/zoos
    @GetMapping(value = "/zoos", produces = "application/json")
    public ResponseEntity<?> getAllZoos() {
        List<Zoo> zooList = zooService.getAllZoos();
        return new ResponseEntity<>(zooList, HttpStatus.OK);
    }

    // GET http://localhost:2019/zoos/zoo/{zooid}
    @GetMapping(value = "/zoo/{zooid}", produces = "application/json")
    public ResponseEntity<?> getZooById(@PathVariable long zooid) {
        Zoo zoo = zooService.findById(zooid);
        return new ResponseEntity<>(zoo, HttpStatus.OK);
    }

    // POST http://localhost:2019/zoos/zoo
    @PostMapping(value = "/zoo", consumes = "application/json")
    public ResponseEntity<?> addZoo(@Valid @RequestBody Zoo newZoo) {

        //Set id to 0 so save method knows this is a POST
        newZoo.setZooid(0);
        newZoo = zooService.save(newZoo);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newZooURI = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{zooid}")
        .buildAndExpand(newZoo.getZooid())
        .toUri();
        responseHeaders.setLocation(newZooURI);
        return new ResponseEntity<>(responseHeaders, HttpStatus.CREATED);
    }


    // PUT http://localhost:2019/zoos/zoo/{zooid}
    @PutMapping(value = "/zoo/{zooid}", consumes = "application/json")
    public ResponseEntity<?> replaceZooById(@PathVariable long zooid, @Valid @RequestBody Zoo replaceZoo) {
       //Set id to zooid so save method knows this is a PUT
        replaceZoo.setZooid(zooid);
        zooService.save(replaceZoo);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    // PATCH http://localhost:2019/zoos/zoo/{zooid}
    @PatchMapping(value = "/zoo/{zooid}", consumes = "application/json")
    public ResponseEntity<?> updateZooById(@PathVariable long zooid, @RequestBody Zoo updateZoo) {
        updateZoo.setZooid(zooid);
        zooService.update(updateZoo, zooid);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    // DELETE http://localhost:2019/zoos/zoo/{zooid}
    @DeleteMapping(value = "/zoo/{zooid}")
    public ResponseEntity<?> deleteZooById(@PathVariable long zooid) {
        zooService.delete(zooid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
