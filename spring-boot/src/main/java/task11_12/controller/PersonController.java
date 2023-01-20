package task11_12.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import task11_12.converter.PersonConverter;
import task11_12.dto.PersonDto;
import task11_12.model.Person;
import task11_12.service.PersonService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "person/")
public class PersonController {

   private final PersonService personService;

   private final PersonConverter personConverter;


   @GetMapping("persons")
   public List<Person> getPersons(){
       return personService.getPersons();
   }

   @GetMapping()
   public PersonDto getPersonDtoByNameAndAge(@RequestParam String name, @RequestParam Integer age){
       return personConverter.personToPersonDto(personService.getPersonByNameAndAge(name, age));
   }

   @GetMapping("more/{n}")
   public List<PersonDto> moreThan(@PathVariable Integer n){
       return personConverter.listPersonToListPersonDto(personService.moreThan(n));
   }

   @GetMapping("getAge/{age}")
   public List<PersonDto> getPersonsDtoByAge(@PathVariable Integer age){
       return personConverter.listPersonToListPersonDto(personService.getPersonByAge(age));
   }

   @GetMapping("getNameAge")
   public PersonDto getPersonNameAge(@RequestParam String name, @RequestParam Integer Age){
       return personConverter.personToPersonDto(personService.getPersonByNameAndAge(name, Age));
   }



    @GetMapping("personsDto")
    public List<PersonDto> getPersonsDto(){
        return personConverter.listPersonToListPersonDto(personService.getPersons());
    }
}
