package task16.service;


import task16.model.Department;
import task16.service.dto.DepartmentDto;

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
