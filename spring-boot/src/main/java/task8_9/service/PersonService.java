package task8_9.service;

import task8_9.model.Person;

import java.util.List;


public interface PersonService {

    List<Person> getAllPerson();

    Person getPersonByName(String name);

    Person getPersonById(Long id);

    Person replacePerson(Long id, Integer year);

    String deletePerson(Long id);


}
