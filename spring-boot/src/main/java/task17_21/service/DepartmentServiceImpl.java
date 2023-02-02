package task17_21.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import task17_21.email.SendEmail;
import task17_21.exception.PersonDepartmentException;
import task17_21.exception.PersonDepartmentExceptionEnum;
import task17_21.model.Department;
import task17_21.model.Person;
import task17_21.repository.DepartmentRepository;
import task17_21.repository.PersonRepository;
import task17_21.service.converter.DepartmentConverter;
import task17_21.service.dto.DepartmentDto;

import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {


    private final DepartmentRepository departmentRepository;

    private final DepartmentConverter departmentConverter;

    private final PersonRepository personRepository;

    private final SendEmail sendEmail;


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
        {
            String message = PersonDepartmentExceptionEnum.PERSON_NOT_FOUND.getMessage();
            throw new PersonDepartmentException(message);
        });


        Department department = departmentRepository.findById(idDep)
                .orElseThrow(() ->
                {
                    String message = PersonDepartmentExceptionEnum.DEPARTMENT_NOT_FOUND.getMessage();
                    throw new PersonDepartmentException(message);
                });

        person.setDepartment(department);
        departmentRepository.save(department);

    }


    @Override
    public void deletePerson(Long id) {
        Person person = personRepository.findById(id).orElseThrow(() ->
        {
            String message = PersonDepartmentExceptionEnum.PERSON_NOT_FOUND.getMessage();
            throw new PersonDepartmentException(message);
        });

        personRepository.delete(person);
    }

    @Override
    public void deleteDepartment(Long id) {
        Department dep = departmentRepository.findById(id).orElseThrow(() ->
        {
            String message = PersonDepartmentExceptionEnum.DEPARTMENT_NOT_FOUND.getMessage();
            throw new PersonDepartmentException(message);
        });
        departmentRepository.delete(dep);
    }

    @Override
    public DepartmentDto getDepartmentDto(Long id) {
        Department dep = departmentRepository.findById(id).orElseThrow(() ->
        {
            String message = PersonDepartmentExceptionEnum.DEPARTMENT_NOT_FOUND.getMessage();
            throw new PersonDepartmentException(message);
        });
        return departmentConverter.departmentToDto(dep);
    }

    @Override
    public Department getDepartment(long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() ->
                {
                    String message = PersonDepartmentExceptionEnum.DEPARTMENT_NOT_FOUND.getMessage();
                    throw new PersonDepartmentException(message);
                });
    }
}
