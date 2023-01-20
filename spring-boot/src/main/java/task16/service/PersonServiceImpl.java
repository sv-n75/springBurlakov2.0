package task16.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import task16.exception.PersonDepartmentException;
import task16.exception.PersonDepartmentExceptionEnum;
import task16.model.Person;
import task16.repository.PersonRepository;
import task16.service.converter.PersonConverter;
import task16.service.dto.PersonDto;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {


    private final PersonRepository personRepository;
    private final PersonConverter personConverter;


    @Override
    public Person getPersonByNameAndAge(String name, Integer age) {
        Person p = personRepository.findFirstByNameAndAge(name, age);
        if (p == null) throw new PersonDepartmentException(PersonDepartmentExceptionEnum
                .PERSON_NOT_FOUND.getMessage());
        return personRepository.findFirstByNameAndAge(name, age);
    }

    @Override
    public PersonDto getPersonDtoById(Long id) {
        return personConverter.convertToDto(personRepository.findById(id).orElseThrow(() ->
                new PersonDepartmentException(PersonDepartmentExceptionEnum
                        .PERSON_NOT_FOUND.getMessage())));
    }

    @Override
    public PersonDto getPersonDtoNameAge(String name, Integer age) {
        Person person = personRepository.findFirstByNameAndAge(name, age);
        if (person == null)
            throw new PersonDepartmentException(PersonDepartmentExceptionEnum.PERSON_NOT_FOUND.getMessage());
        return personConverter.convertToDto(person);
    }

    @Override
    public List<PersonDto> getPersonByAge(Integer age) {
        List<Person> p = personRepository.findByAge(age);
        if (p.isEmpty())
            throw new PersonDepartmentException(PersonDepartmentExceptionEnum.PERSON_NOT_FOUND.getMessage());
        return personConverter.convertToDtList(p);
    }


    @Override
    public List<PersonDto> getPersons() {
        return personConverter.convertToDtList(personRepository.findAll());
    }


    @Override
    public void addPerson(Person person) {
        personRepository.save(person);
    }

    @Override
    public void addPersons(List<Person> personList) {
        personRepository.saveAll(personList);
    }

    @Override
    public List<PersonDto> moreThan(Integer n) {
        List<Person> personList = personRepository.findMoreThan(n);
        if (personList.isEmpty()){
            throw new PersonDepartmentException(PersonDepartmentExceptionEnum.PERSON_NOT_FOUND.getMessage());
        }
        return personConverter.convertToDtList(personList);
    }

    @Override
    public Person getPersonById(Long id) {
        return personRepository.findById(id).orElseThrow(() ->
                new PersonDepartmentException(PersonDepartmentExceptionEnum
                        .PERSON_NOT_FOUND.getMessage()));
    }

}

