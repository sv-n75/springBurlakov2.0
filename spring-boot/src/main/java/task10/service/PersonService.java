package task10.service;

import task10.model.Person;

import java.util.List;

public interface PersonService {

    Person getPersonByNameAndYear(String name, Integer age);

    List<Person> getPersonByAge(Integer age);

    Person addPerson(Person person);

    List<Person> getPersons();
}
