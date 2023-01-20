package task17_21.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class DepartmentDto {

    private String name;
    private Integer values;
    private List<PersonDepartmentDto> personDtoList;
}
