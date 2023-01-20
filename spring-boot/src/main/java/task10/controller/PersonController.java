package task10.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import task10.model.Person;
import task10.service.PersonService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "person/")
public class PersonController {

    private final PersonService personService;

    @GetMapping()
    public Person getPersonNameAndAge(@RequestParam String name, @RequestParam Integer age) {
        return personService.getPersonByNameAndYear(name, age);
    }

    @GetMapping("persons")
    public List<Person> getPersons(){
        return personService.getPersons();
    }

    @GetMapping("getAge/{age}")
    public List<Person> getPersonsByAge(@PathVariable Integer age){
        return personService.getPersonByAge(age);
    }

    @PostMapping
    public Person addPerson(@RequestBody Person person){
        return personService.addPerson(person);
    }
}
