package task11_12.service;


import task11_12.model.Person;

import java.util.List;

public interface PersonService {

    Person getPersonByNameAndAge(String name, Integer age);

    List<Person> getPersonByAge(Integer age);

    List<Person> getPersons();

    Person addPerson(Person person);

    List<Person> moreThan();


}
