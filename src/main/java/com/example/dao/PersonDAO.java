package com.example.dao;

import com.example.entity.Person;

import java.util.List;

public interface PersonDAO {
    Person save(Person Person);
    Person findById(Long id);
    List<Person> findAll();
    void delete(Long id);
}
