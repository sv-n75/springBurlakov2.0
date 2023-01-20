package task17_21.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import task17_21.model.Department;
import task17_21.service.DepartmentService;
import task17_21.service.dto.DepartmentDto;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "person/")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping("departments")
    public List<DepartmentDto> getDepartments() {
        List<DepartmentDto> departmentDtoList = departmentService.getDepartments();
        log.info("this departmentList contains " + departmentDtoList.size() + " departments" );
        return departmentDtoList;
    }

    @GetMapping("idDep/{id}")
    public DepartmentDto getDepartmentDto(@PathVariable Long id) {
        return departmentService.getDepartmentDto(id);
    }

    @PostMapping("addDep")
    public String addDepartment(@RequestBody Department department) {
        departmentService.addDepartment(department);
        return "This department is added";
    }

    @PutMapping("addPD")
    public String addPersonToDepartment(@RequestParam Long idP, @RequestParam Long idDep) {
        departmentService.addPersonToDepartment(idP, idDep);
        return "Person is added into this department";
    }

    @DeleteMapping("{id}")
    public String deletePerson(@PathVariable Long id) {
        departmentService.deletePerson(id);
        return "Person is deleted";
    }

    @DeleteMapping("deleteDep/{id}")
    public String deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
        return "Department is deleted";
    }
}





