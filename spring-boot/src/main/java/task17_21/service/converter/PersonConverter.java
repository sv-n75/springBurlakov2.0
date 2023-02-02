package task17_21.service.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import task17_21.model.Person;
import task17_21.service.dto.PersonDepartmentDto;
import task17_21.service.dto.PersonDto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PersonConverter {

    private final PassportConverter passportConverter;


    public PersonDto convertToDto(Person person) {
        if (person.getDepartment() == null)
            return new PersonDto(person.getSurname(), person.getName(), person.getPatronymic(),
                    (LocalDate.now().getYear() - person.getBirthday().getYear()),
                    passportConverter.convertPassportToPassportDTO(person.getPersonPassport()), null);
        return new PersonDto(person.getSurname(), person.getName(), person.getPatronymic(),
                (LocalDate.now().getYear() - person.getBirthday().getYear()),
                passportConverter.convertPassportToPassportDTO(person.getPersonPassport()),
                person.getDepartment().getName());
    }

    public List<PersonDto> convertToDtList(List<Person> personList) {
        return personList.stream().map(p -> convertToDto(p)).collect(Collectors.toList());
    }

    public PersonDepartmentDto convertToPersonDepartmentDto(Person person) {
        return new PersonDepartmentDto(person.getSurname(), person.getName());
    }

    public List<PersonDepartmentDto> convertPersonToPersonDepDtoList(List<Person> personList) {
        return personList.stream().map(p -> convertToPersonDepartmentDto(p)).collect(Collectors.toList());
    }

}
