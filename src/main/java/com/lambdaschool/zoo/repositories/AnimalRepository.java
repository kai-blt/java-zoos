package com.lambdaschool.zoo.repositories;

import com.lambdaschool.zoo.models.Animal;
import com.lambdaschool.zoo.views.AnimalCountZoo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnimalRepository extends CrudRepository <Animal, Long>{
    @Query(value =
            "SELECT a.animaltype, a.animalid, count(za.zooid) as countzoos " +
            "FROM animals a " +
            "LEFT JOIN zooanimals za " +
            "ON a.animalid = za.animalid " +
            "GROUP BY a.animalid " +
            "ORDER BY a.animaltype", nativeQuery = true)
    List<AnimalCountZoo> getZooCount();
}
