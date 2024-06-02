package com.example.service;

import com.example.dao.PersonDAO;
import com.example.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonDAO personDAO;

    public Person savePerson(Person Person) {
        return personDAO.save(Person);
    }

    public Person findPersonById(Long id) {
        return personDAO.findById(id);
    }

    public List<Person> findAllPersons() {
        return personDAO.findAll();
    }

    public void deletePerson(Long id) {
        personDAO.delete(id);
    }
}
