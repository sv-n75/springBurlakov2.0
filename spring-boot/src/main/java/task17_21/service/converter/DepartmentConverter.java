package task17_21.service.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import task17_21.model.Department;
import task17_21.service.dto.DepartmentDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DepartmentConverter {

    private final PersonConverter personConverter;

    public DepartmentDto departmentToDto(Department department) {
        return new DepartmentDto(department.getName(), department.getPersonList().size()
                , personConverter.convertPersonToPersonDepDtoList(department.getPersonList()));
    }

    public List<DepartmentDto> departToDepartDtoList(List<Department> departmentList) {
        return departmentList.stream().map(d -> departmentToDto(d)).collect(Collectors.toList());
    }

}
