package task8_9.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import task8_9.model.Person;
import task8_9.repository.PersonRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;


    @Override
    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

    @Override
    public Person getPersonById(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new IllegalStateException("Can't find with id " + id));
    }

    @Override
    public Person replacePerson(Long id, Integer year) {
        final var person = personRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Can't find with id " + id));
        person.setYear(year);
        return personRepository.save(person);
    }

    @Override
    public String deletePerson(Long id) {
        personRepository.findById(id).orElseThrow(() -> new IllegalStateException("Can't find with id " + id));
        personRepository.deleteById(id);
        return "This person with id- " + id  + " is deleted";
    }

    @Override
    public Person getPersonByName(String name) {
        return personRepository.findFirstByName(name)//.stream().findFirst()
                .orElseThrow(() -> new IllegalStateException("Can't find with id " + name));
    }
}
