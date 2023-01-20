package task17_21.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import task17_21.model.Person;
import task17_21.service.PersonService;
import task17_21.service.dto.PersonDto;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "person/")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping("add")
    public String addPerson(@RequestBody Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "person invalid";
        personService.addPerson(person);
        return "VALID";
    }

    @PostMapping("addPersons")
    public String addPersons(@RequestBody List<Person> personList) {
        personService.addPersons(personList);
        return "This personList is added";
    }

    @GetMapping("persons")
    public List<PersonDto> getPersons() {
        List<PersonDto> personDtoList = personService.getPersons();
        log.info("this List contains " + personDtoList.size() + " persons");
        return personDtoList;
    }

    @GetMapping
    public PersonDto getNameAge(@RequestParam String name, @RequestParam Integer age) {
        return personService.getPersonDtoNameAge(name, age);
    }

    @GetMapping("age/{age}")
    public List<PersonDto> getAge(@PathVariable Integer age) {
        List<PersonDto> personDtoList = personService.getPersonByAge(age);
        log.info("this list contains " + personDtoList.size() + " persons, age = " + age);
        return personDtoList;
    }

    @GetMapping("id/{id}")
    public PersonDto getPersonById(@PathVariable Long id) {
        return personService.getPersonDtoById(id);
    }

    @GetMapping("more/{n}")
    public List<PersonDto> moreThan(@PathVariable Integer n) {
        return personService.moreThan(n);
    }

}
