package task17_21.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import task17_21.email.SendEmail;
import task17_21.exception.PersonDepartmentException;
import task17_21.exception.PersonDepartmentExceptionEnum;
import task17_21.model.Person;
import task17_21.repository.PersonRepository;
import task17_21.service.converter.PersonConverter;
import task17_21.service.dto.PersonDto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {


    private final PersonRepository personRepository;
    private final PersonConverter personConverter;
    private final SendEmail sendEmail;


    @Override
    public PersonDto getPersonDtoNameAge(String name, Integer age) {
        List<Person> personList = personRepository.findByName(name);
        if (personList.isEmpty()) {
            throw new PersonDepartmentException(PersonDepartmentExceptionEnum.PERSON_NOT_FOUND.getMessage());
        }
        Person person = personList.stream().filter((p) -> (LocalDate.now().getYear() - p.getBirthday().getYear()) == age)
                .findFirst().orElseThrow(() ->
                {
                    String message = PersonDepartmentExceptionEnum.PERSON_NOT_FOUND.getMessage();
                    throw new PersonDepartmentException(message);
                });

        return personConverter.convertToDto(person);
    }

    @Override
    public PersonDto getPersonDtoById(Long id) {
        return personConverter.convertToDto(personRepository.findById(id).orElseThrow(() ->
        {
            String message = PersonDepartmentExceptionEnum.PERSON_NOT_FOUND.getMessage();
            throw new PersonDepartmentException(message);
        }));
    }


    @Override
    public List<PersonDto> getPersonByAge(Integer age) {
        List<Person> personList = personRepository.findAll();
        List<Person> people = personList.stream()
                .filter((p) -> (LocalDate.now().getYear() - p.getBirthday().getYear()) == age)
                .collect(Collectors.toList());
        if (people.isEmpty())
        {
            String message = PersonDepartmentExceptionEnum.PERSON_NOT_FOUND.getMessage();
            throw new PersonDepartmentException(message);
        }

        return personConverter.convertToDtList(people);
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
        if (personList.isEmpty()) {
            throw new PersonDepartmentException(PersonDepartmentExceptionEnum.PERSON_NOT_FOUND.getMessage());
        }
        return personConverter.convertToDtList(personList);
    }

    @Override
    public Person getPersonById(Long id) {
        return personRepository.findById(id).orElseThrow(() ->
        {
            String message = PersonDepartmentExceptionEnum.PERSON_NOT_FOUND.getMessage();
            throw new PersonDepartmentException(message);
        });
    }

    @Override
    public String getPersonByNullPatronymic() {
        List<Person> personList = personRepository.findAll();
        List<Person> people = personList.stream()
                .filter((p) -> p.getPatronymic() == null)
                .collect(Collectors.toList());

        return personConverter.convertToDtList(people).toString();
    }
}

