package com.dailycode.SpringBoot.repository;

import com.dailycode.SpringBoot.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

    public Department findBydepartmentName(String departmentName);
    public Department findBydepartmentNameIgnoreCase(String departmentName);
}
