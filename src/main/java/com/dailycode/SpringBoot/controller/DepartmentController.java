package com.dailycode.SpringBoot.controller;

import com.dailycode.SpringBoot.entity.Department;
import com.dailycode.SpringBoot.exception.DepartmentNotFoundException;
import com.dailycode.SpringBoot.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger logs = LoggerFactory.getLogger(Department.class);
    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        logs.info("this is SaveDepartment function ");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> getDepartments(){
        logs.info("this is getDepartments function ");
        return departmentService.getDepartment();
    }
    @GetMapping("/departments/{id}")
    public Department getDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        logs.info("this is getDepartmentById function ");
        return departmentService.getDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        logs.info("this is deleteDepartmentById function ");
        departmentService.deleteById(departmentId);
        return "Successfully deleted the department!!";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,@RequestBody Department department){
        logs.info("this is updateDepartment function ");
        return departmentService.updateDepartment(departmentId,department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchBydepartmentName(@PathVariable("name") String name){
        return departmentService.fetchBydepartmentName(name);
    }
}
