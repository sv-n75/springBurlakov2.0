package task11_12.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import task11_12.exception.PersonException;
import task11_12.model.Person;
import task11_12.repository.PersonRepository;

import java.util.List;

import static task11_12.exception.PersonExceptionEnum.PERSON_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class PersonServiceImp implements PersonService{

   private final PersonRepository personRepository;


    @Override
    public Person getPersonByNameAndAge(String name, Integer age) {

        return personRepository.findFirstByNameAndAge(name, age)
                .orElseThrow(()->new PersonException(PERSON_NOT_FOUND.getMessage()));

    }

    @Override
    public List<Person> getPersonByAge(Integer age) {
        List<Person> persons =  personRepository.findByAge(age);
        if (persons.isEmpty()){
            throw new PersonException(PERSON_NOT_FOUND.getMessage());

        }
        return persons;
    }

    @Override
    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    @Override
    public Person addPerson(Person person) {
        return addPerson(person);
    }

    @Override
    public List<Person> moreThan(Integer n) {
        List<Person> personList = personRepository.findMoreThan(n);
        if (personList.isEmpty()){
            throw new PersonException(PERSON_NOT_FOUND.getMessage());
        }
        return personList;
    }
}
