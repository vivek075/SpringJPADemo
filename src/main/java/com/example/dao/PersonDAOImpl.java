package com.example.dao;

import com.example.entity.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class PersonDAOImpl implements PersonDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Person save(Person Person) {
        if (Person.getId() == null) {
            entityManager.persist(Person);
            return Person;
        } else {
            return entityManager.merge(Person);
        }
    }

    @Override
    public Person findById(Long id) {
        return entityManager.find(Person.class, id);
    }

    @Override
    public List<Person> findAll() {
        TypedQuery<Person> query = entityManager.createQuery("SELECT p FROM Person p", Person.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Person Person = entityManager.find(Person.class, id);
        if (Person != null) {
            entityManager.remove(Person);
        }
    }
}