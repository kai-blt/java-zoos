package com.lambdaschool.zoo.services;

import com.lambdaschool.zoo.models.Zoo;
import com.lambdaschool.zoo.repositories.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "zooService")
public class ZooServiceImpl implements ZooService {
    @Autowired
    private ZooRepository zoorepos;

    @Override
    public List<Zoo> getAllZoos() {
        List<Zoo> zooList = new ArrayList<>();
        zoorepos.findAll().iterator().forEachRemaining(zooList::add);
        System.out.println(zooList);
        return zooList;
    }
}
