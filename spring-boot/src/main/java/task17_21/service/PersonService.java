package task17_21.service;


import org.springframework.validation.annotation.Validated;
import task17_21.model.Person;
import task17_21.service.dto.PersonDto;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface PersonService {

    PersonDto getPersonDtoById(Long id);

    PersonDto getPersonDtoNameAge(String name, Integer age);

   List<PersonDto> getPersonByAge(Integer age);

    List<PersonDto> getPersons();

    void addPerson(@Valid Person person);

    void addPersons(List<@Valid Person> personList);

   List<PersonDto> moreThan(Integer n);

    Person getPersonById(Long id);

    String getPersonByNullPatronymic();


}

