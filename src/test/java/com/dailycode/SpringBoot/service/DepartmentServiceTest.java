package com.dailycode.SpringBoot.service;

import com.dailycode.SpringBoot.entity.Department;
import com.dailycode.SpringBoot.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {
    @Autowired
    private DepartmentService departmentService;

    @Mock
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
    Department department = new Department().builder()
            .departmentName("IT")
            .departmentAddress("Delhi")
            .departmentCode("IT-01")
            .departmentId(1L)
            .build();

        Mockito.when(departmentRepository.findBydepartmentNameIgnoreCase("IT")).thenReturn(department);


    }

    @Test
    @DisplayName("name test")
    public void validDepartmentName(){
        String departmentName = "IT";
        Department depart = departmentService.fetchBydepartmentName(departmentName);

        assertEquals(depart.getDepartmentName(),departmentName);
    }
}