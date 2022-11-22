package task16.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import task16.model.Department;
import task16.service.DepartmentService;
import task16.service.dto.DepartmentDto;

import java.util.List;

@RestController
@RequestMapping(path = "person")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping("/departments")
    public List<DepartmentDto> getDepartments() {
        return departmentService.getDepartments();
    }

    @GetMapping("/idDep/{id}")
    public DepartmentDto getDepartmentDto(@PathVariable Long id) {
        return departmentService.getDepartmentDto(id);
    }

    @PostMapping("/addDep")
    public String addDepartment(@RequestBody Department department) {
        departmentService.addDepartment(department);
        return "This department is added";
    }

    @PutMapping("/addPD")
    public String addPersonToDepartment(@RequestParam Long idP, @RequestParam Long idDep) {
        departmentService.addPersonToDepartment(idP, idDep);
        return "Person is added into this department";
    }

    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable Long id) {
        departmentService.deletePerson(id);
        return "Person is deleted";
    }

    @DeleteMapping("/deleteDep/{id}")
    public String deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
        return "Department is deleted";
    }
}





