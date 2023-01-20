package task17_21.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class PersonDto {

    private String surname;
    private String name;
    private String patronymic;
    private Integer age;
    private PassportDto passportDto;
    private String departmentName;


}
