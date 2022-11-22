package task11_12.dto;

import lombok.Data;
import task11_12.model.Person;

@Data
public class PersonDto {

    private String surname;
    private String name;
    private String patronymic;
    private Integer age;

    public PersonDto(Person person) {
        surname = person.getSurname();
        name = person.getName();
        patronymic = person.getPatronymic();
        age = person.getAge();
    }
}
