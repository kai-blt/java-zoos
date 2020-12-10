package com.lambdaschool.zoo.services;

import com.lambdaschool.zoo.repositories.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "zooService")
public class ZooServiceImpl implements ZooService {
    @Autowired
    private ZooRepository zoorepos;
}
