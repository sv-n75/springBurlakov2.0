package task13_14_15.service;


import task13_14_15.model.Person;
import task13_14_15.service.dto.PersonDto;
import java.util.List;

public interface PersonService {

    Person getPersonByNameAndAge(String name, Integer age);

    PersonDto getPersonDtoNameAge(String name, Integer age);

    List<PersonDto> getPersonByAge(Integer age);

    List<PersonDto> getPersons();

    void addPerson(Person person);

    void addPersons(List<Person> personList);

    List<Person> moreThan();
}
