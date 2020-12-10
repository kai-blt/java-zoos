package com.lambdaschool.zoo.services;

import com.lambdaschool.zoo.models.Telephone;
import com.lambdaschool.zoo.models.Zoo;
import com.lambdaschool.zoo.models.ZooAnimal;
import com.lambdaschool.zoo.repositories.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "zooService")
public class ZooServiceImpl implements ZooService {
    @Autowired
    private ZooRepository zoorepos;

    @Override
    public List<Zoo> getAllZoos() {
        List<Zoo> zooList = new ArrayList<>();
        zoorepos.findAll().iterator().forEachRemaining(zooList::add);
        return zooList;
    }

    @Override
    public Zoo findById(long zooid) {
        return zoorepos.findById(zooid)
            .orElseThrow(() -> new EntityNotFoundException("Zoo " + zooid + " Not Found"));
    }

    @Transactional
    @Override
    public Zoo save(Zoo zoo) {
        //Save method differentiates between PUT and POST
        //By checking the item's id. If 0 its a POST, has valid id = PUT

        //Create new Zoo object for validation
        Zoo newZoo = new Zoo();

        //PUT - validate if id is a valid id
        if (zoo.getZooid() != 0) {
            zoorepos.findById(zoo.getZooid())
                    .orElseThrow(() -> new EntityNotFoundException("Zoo " + zoo.getZooid() + " Not Found"));
            newZoo.setZooid(zoo.getZooid());
        }

        //POST - validate all single field data for correctness through setters
        newZoo.setZooname(zoo.getZooname());


        //POST - validate all relational data for correctness
        //One To Many -> Telephone
        newZoo.getTelephones().clear();
        for (Telephone t : zoo.getTelephones()) {
            Telephone newTelephone = new Telephone();
            newTelephone.setPhonenumber(t.getPhonenumber());
            newTelephone.setPhonetype(t.getPhonetype());
            newTelephone.setZoo(newZoo);
            newZoo.getTelephones().add(newTelephone);
        }

        //One To Many -> ZooAnimal
        newZoo.getAnimals().clear();
        for (ZooAnimal a : zoo.getAnimals()) {
            ZooAnimal newAnimal = new ZooAnimal();
            newAnimal.setAnimal(a.getAnimal());
            newAnimal.setIncomingzoo(a.getIncomingzoo());
            newAnimal.setZoo(newZoo);
            newZoo.getAnimals().add(newAnimal);
        }

        return zoorepos.save(newZoo);
    }

    @Transactional
    @Override
    public void delete(long zooid) {
        zoorepos.deleteById(zooid);
    }
}
