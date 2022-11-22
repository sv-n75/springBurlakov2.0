package task11_12.converter;

import org.springframework.stereotype.Component;
import task11_12.dto.PersonDto;
import task11_12.model.Person;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonConverter {

    public PersonDto personToPersonDto(Person person){
        return new PersonDto(person);
    }

    public List<PersonDto> listPersonToListPersonDto(List<Person> p){
        return p.stream().map(this::personToPersonDto).collect(Collectors.toList());
    }

}
