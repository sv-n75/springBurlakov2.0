package task16.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import task16.model.Person;
import task16.service.PersonService;
import task16.service.dto.PersonDto;

import java.util.List;

@RestController
@RequestMapping(path = "person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping("/add")
    public String addPerson(@RequestBody Person person) {
        personService.addPerson(person);
        return "This Person is added";
    }

    @PostMapping("/addPersons")
    public String addPersons(@RequestBody List<Person> personList) {
        personService.addPersons(personList);
        return "This personList is added";
    }

    @GetMapping("/persons")
    public List<PersonDto> getPersons() {
        return personService.getPersons();
    }

    @GetMapping
    public PersonDto getNameAge(@RequestParam String name, @RequestParam Integer age) {
        return personService.getPersonDtoNameAge(name, age);
    }

    @GetMapping("/age/{age}")
    public List<PersonDto> getAge(@PathVariable Integer age) {
        return personService.getPersonByAge(age);
    }

    @GetMapping("/id/{id}")
    public PersonDto getPersonById(@PathVariable Long id) {
        return personService.getPersonDtoById(id);
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable Long id) {
        return personService.getPersonById(id);
    }
}
