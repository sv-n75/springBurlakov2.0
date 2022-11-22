package task13_14_15.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import task13_14_15.model.Person;
import task13_14_15.service.PersonService;
import task13_14_15.service.dto.PersonDto;

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
}
