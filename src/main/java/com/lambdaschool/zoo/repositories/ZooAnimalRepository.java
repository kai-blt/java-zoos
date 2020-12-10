package com.lambdaschool.zoo.repositories;

import com.lambdaschool.zoo.models.ZooAnimal;
import com.lambdaschool.zoo.models.ZooAnimalId;
import org.springframework.data.repository.CrudRepository;

public interface ZooAnimalRepository extends CrudRepository<ZooAnimal, ZooAnimalId> {
}
