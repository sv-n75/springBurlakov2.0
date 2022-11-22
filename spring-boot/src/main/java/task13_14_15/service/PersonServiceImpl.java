package task13_14_15.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import task13_14_15.exception.PersonException;
import task13_14_15.model.Person;
import task13_14_15.repository.PersonRepository;
import task13_14_15.service.converter.PersonConverter;
import task13_14_15.service.dto.PersonDto;

import java.util.ArrayList;
import java.util.List;

import static task13_14_15.exception.PersonExceptionEnum.PERSON_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {


    private final PersonRepository personRepository;
    private final PersonConverter personConverter;

    List<Person> personList = new ArrayList<>();

    @Override
    public Person getPersonByNameAndAge(String name, Integer age) {
        Person p = personRepository.findFirstByNameAndAge(name, age);
        if (p == null) throw new PersonException(PERSON_NOT_FOUND.getMessage());
        return personRepository.findFirstByNameAndAge(name, age);
    }

    @Override
    public PersonDto getPersonDtoNameAge(String name, Integer age) {
        Person person = personRepository.findFirstByNameAndAge(name, age);
        if (person == null) throw new PersonException(PERSON_NOT_FOUND.getMessage());
        return personConverter.convertToDto(person);
    }

    @Override
    public List<PersonDto> getPersonByAge(Integer age) {
        List<Person> p = personRepository.findByAge(age);
        if (p.isEmpty()) throw new PersonException(PERSON_NOT_FOUND.getMessage());
        return personConverter.convertToDtList(personRepository.findByAge(age));
    }


    @Override
    public List<PersonDto> getPersons() {
        return personConverter.convertToDtList(personRepository.findAll());
    }


    @Override
    public void addPerson(Person person) {
        personList.add(person);
        personRepository.save(person);
    }

    @Override
    public void addPersons(List<Person> personList) {
        personList.addAll(personList);
        personRepository.saveAll(personList);
    }

    @Override
    public List<Person> moreThan() {
        return null;
    }
}
