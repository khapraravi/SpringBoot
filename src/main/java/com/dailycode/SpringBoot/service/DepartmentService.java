package com.dailycode.SpringBoot.service;

import com.dailycode.SpringBoot.entity.Department;
import com.dailycode.SpringBoot.exception.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

   public List<Department> getDepartment();

   public  Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    public void deleteById(Long departmentId);

    public Department updateDepartment(Long departmentId, Department department);

   public Department fetchBydepartmentName(String name);
}
