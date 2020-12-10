package com.lambdaschool.zoo.repositories;

import com.lambdaschool.zoo.models.ZooAnimal;
import org.springframework.data.repository.CrudRepository;

public interface ZooAnimalRepository extends CrudRepository<ZooAnimal, Long> {
}
