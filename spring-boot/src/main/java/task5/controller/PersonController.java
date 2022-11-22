package task5.controller;

import org.springframework.web.bind.annotation.*;
import task5.model.Person;
import task5.service.PersonService;
import task5.service.dto.PersonDTO;

@RestController
@RequestMapping(path = "person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("{name}")
    public PersonDTO getPersonByNameFromPathVariable(@PathVariable String name) {
        return personService.getPersonByName(name);
    }

    @GetMapping("/get-name")
    public PersonDTO getPersonByNameFromRequestParam(@RequestParam String name) {
        return personService.getPersonByName(name);
    }

    @GetMapping("/description")
    public PersonDTO getPersonByNameResponseBody(@RequestBody Person person) {
        return personService.getPersonByPerson(person);
    }

    @PostMapping
    public String addNewPerson(@RequestBody Person person) {
        personService.addPerson(person);
        return "this person with name " + person.getName() + " is added";

    }

    @PutMapping("{name}")
    public String updatePerson(@PathVariable String name, @RequestBody Person person) {
        personService.updatePerson(name, person);
        return "this person with name " + name + " is updated";
    }

    @DeleteMapping("{name}")
    public String deletePerson(@PathVariable String name) {
        personService.deletePerson(name);
        return "this person with name " + name + " is deleted";
    }
}
