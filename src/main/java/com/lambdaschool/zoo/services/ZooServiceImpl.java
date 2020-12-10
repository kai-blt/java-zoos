package com.lambdaschool.zoo.services;

import com.lambdaschool.zoo.models.Animal;
import com.lambdaschool.zoo.models.Telephone;
import com.lambdaschool.zoo.models.Zoo;
import com.lambdaschool.zoo.models.ZooAnimal;
import com.lambdaschool.zoo.repositories.AnimalRepository;
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

    @Autowired
    private AnimalRepository animalrepos;

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
//        newZoo.getAnimals().clear();
//        for (ZooAnimal za : zoo.getAnimals()) {
//            Animal newAnimal = new Animal();
//            ZooAnimal newZooAnimal = new ZooAnimal();
//
//            newAnimal.setAnimalid(a.getAnimal().getAnimalid());
//            newAnimal.setAnimaltype(a.getAnimal().getAnimaltype());
//
//            newZooAnimal.setAnimal(newAnimal);
//            newZooAnimal.setIncomingzoo(a.getIncomingzoo());
//            newZooAnimal.setZoo(newZoo);
//            newZoo.getAnimals().add(newZooAnimal);
//        }
        newZoo.getAnimals().clear();
        for (ZooAnimal za : zoo.getAnimals()) {
            Animal newAnimal = animalrepos.findById(za.getAnimal().getAnimalid())
                    .orElseThrow(() -> new EntityNotFoundException("ZooAnimal " + za.getAnimal() + " Not Found"));

            newZoo.getAnimals().add(new ZooAnimal(newZoo, newAnimal));
        }


        System.out.println(newZoo);
        return zoorepos.save(newZoo);
    }

    @Transactional
    @Override
    public void delete(long zooid) {
        zoorepos.deleteById(zooid);
    }
}
