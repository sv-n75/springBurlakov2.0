package task16.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import task16.exception.PersonDepartmentException;
import task16.exception.PersonDepartmentExceptionEnum;
import task16.model.Department;
import task16.model.Person;
import task16.repository.DepartmentRepository;
import task16.repository.PersonRepository;
import task16.service.converter.DepartmentConverter;
import task16.service.dto.DepartmentDto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {


    private final DepartmentRepository departmentRepository;

    private final DepartmentConverter departmentConverter;

    private final PersonService personService;

    private final PersonRepository personRepository;


    @Override
    public List<DepartmentDto> getDepartments() {
        return departmentConverter.departToDepartDtoList(departmentRepository.findAll());
    }

    @Override
    public void addDepartment(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public void addPersonToDepartment(Long idP, Long idDep) {

        Person person = personRepository.findById(idP).orElseThrow(() ->
                new PersonDepartmentException(PersonDepartmentExceptionEnum
                        .PERSON_NOT_FOUND.getMessage()));


        Department department = departmentRepository.findById(idDep)
                .orElseThrow(() -> new PersonDepartmentException(PersonDepartmentExceptionEnum
                        .DEPARTMENT_NOT_FOUND.getMessage()));

        person.setDepartment(department);
        departmentRepository.save(department);

    }


    @Override
    public void deletePerson(Long id) {
        Person person = personRepository.findById(id).orElseThrow(() ->
                new PersonDepartmentException(PersonDepartmentExceptionEnum
                        .PERSON_NOT_FOUND.getMessage()));

        personRepository.delete(person);
    }

    @Override
    public void deleteDepartment(Long id) {
        Department dep = departmentRepository.findById(id).orElseThrow(() -> new PersonDepartmentException
                (PersonDepartmentExceptionEnum.DEPARTMENT_NOT_FOUND.getMessage()));
        departmentRepository.delete(dep);
    }

    @Override
    public DepartmentDto getDepartmentDto(Long id) {
        Department dep = departmentRepository.findById(id).orElseThrow(() -> new PersonDepartmentException
                (PersonDepartmentExceptionEnum.DEPARTMENT_NOT_FOUND.getMessage()));
        return departmentConverter.departmentToDto(dep);
    }

    @Override
    public Department getDepartment(long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new PersonDepartmentException(PersonDepartmentExceptionEnum
                        .DEPARTMENT_NOT_FOUND.getMessage()));
    }
}
