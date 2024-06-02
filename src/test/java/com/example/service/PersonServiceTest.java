package com.example.service;

import com.example.entity.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class PersonServiceTest {

    private PersonService personService;

    @Before
    public void setUp() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContextTest.xml");
        personService = context.getBean(PersonService.class);
    }

    /* This is just for testing purpose, hence we are making different assertions in single method.
    * In ideal case different testcases should be created. */
    @Test
    public void testCRUDOperations() {
        // Create
        Person person = new Person();
        person.setName("Vivek Singh");
        person.setEmail("vivek.singh@example.com");

        person = personService.savePerson(person);
        Assert.assertNotNull(person.getId());

        // Read
        Person retrievedPerson = personService.findPersonById(person.getId());
        Assert.assertEquals("Vivek Singh", retrievedPerson.getName());

        // Update
        retrievedPerson.setName("Vivek Kumar Singh");
        personService.savePerson(retrievedPerson);
        Person updatedPerson = personService.findPersonById(retrievedPerson.getId());
        Assert.assertEquals("Vivek Kumar Singh", updatedPerson.getName());

        // Delete
        personService.deletePerson(updatedPerson.getId());
        Person deletedPerson = personService.findPersonById(updatedPerson.getId());
        Assert.assertNull(deletedPerson);

        // Find All
        List<Person> Persons = personService.findAllPersons();
        Assert.assertTrue(Persons.isEmpty());
    }
}