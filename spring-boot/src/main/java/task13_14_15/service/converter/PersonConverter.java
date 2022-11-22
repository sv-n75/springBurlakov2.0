package task13_14_15.service.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import task13_14_15.model.Person;
import task13_14_15.service.dto.PersonDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PersonConverter {

    private final PassportConverter passportConverter;

    public PersonDto convertToDto(Person person) {
        return new PersonDto(person.getSurname(), person.getName()
                , person.getPatronymic(), person.getAge()
                , passportConverter.convertPassportToPassportDTO(person.getPersonPassport()));
    }

    public List<PersonDto> convertToDtList(List<Person> personList) {
        return personList.stream().map(p -> convertToDto(p)).collect(Collectors.toList());
    }
}
