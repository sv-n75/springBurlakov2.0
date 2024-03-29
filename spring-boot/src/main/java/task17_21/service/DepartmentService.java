package task17_21.service;


import task17_21.model.Department;
import task17_21.service.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {


    List<DepartmentDto> getDepartments();

    void addDepartment(Department department);


    void addPersonToDepartment(Long idP, Long idDep);

    void deletePerson(Long id);

    void deleteDepartment(Long id);

    DepartmentDto getDepartmentDto(Long id);

    Department getDepartment(long id);


}
