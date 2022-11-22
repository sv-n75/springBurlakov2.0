package task8_9.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import task8_9.model.Person;
import task8_9.service.PersonService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "person")
public class PersonController {

    private final PersonService personService;

    @GetMapping("/persons")
    public List<Person> getAll() {
        return personService.getAllPerson();
    }
    @GetMapping("id/{id}")
    public Person getPersonById(@PathVariable  Long id){
        return personService.getPersonById(id);
    }

    @GetMapping("{name}")
    public Person getPersonByName(@PathVariable String name){
        return personService.getPersonByName(name);
    }

    @PutMapping("id/{id}")
    public Person updatePeron(@PathVariable Long id, @RequestParam Integer age){
        return personService.replacePerson(id, age);
    }

    @DeleteMapping("id/{id}")
    public String deletePerson(@PathVariable Long id){
        return personService.deletePerson(id);
    }
}
