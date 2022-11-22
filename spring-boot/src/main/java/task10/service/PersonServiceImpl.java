package task10.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import task10.model.Person;
import task10.repository.PersonRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService{

    private final PersonRepository personRepository;


    @Override
    public Person getPersonByNameAndYear(String name, Integer age) {
        return personRepository.findFirstByNameAndAge(name, age)
                .orElseThrow(() -> new IllegalStateException("Can't find with name and age " + name + " " + age));
    }

    @Override
    public List<Person> getPersonByAge(Integer age) {
        return personRepository.findByAge(age);
    }

    @Override
    public Person addPerson(Person person) {
        return person;
    }

    @Override
    public List<Person> getPersons() {
        return personRepository.findAll();
    }
}
