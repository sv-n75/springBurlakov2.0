package task16.service;


import task16.model.Person;
import task16.service.dto.PersonDto;

import java.util.List;

public interface PersonService {

    Person getPersonByNameAndAge(String name, Integer age);

    PersonDto getPersonDtoById(Long id);

    PersonDto getPersonDtoNameAge(String name, Integer age);

    List<PersonDto> getPersonByAge(Integer age);

    List<PersonDto> getPersons();

    void addPerson(Person person);

    void addPersons(List<Person> personList);

    List<PersonDto> moreThan(Integer n);

    Person getPersonById(Long id);

}

