package com.dailycode.SpringBoot.controller;

import com.dailycode.SpringBoot.entity.Department;
import com.dailycode.SpringBoot.exception.DepartmentNotFoundException;
import com.dailycode.SpringBoot.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;
    @BeforeEach
    void setUp() {
        department = Department.builder()
                .departmentName("CE")
                .departmentAddress("Panipat")
                .departmentId(1L)
                .departmentCode("CE-01")
                .build();


    }

    @Test
    void saveDepartment() throws Exception {
        Department inputdepartment = Department.builder()
                .departmentName("CE")
                .departmentAddress("Panipat")
                .departmentCode("CE-01")
                .build();

        Mockito.when(departmentService.saveDepartment(inputdepartment)).thenReturn(department);

        mockMvc.perform(post("/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\t\"departmentName\":\"CE\",\n" +
                        "\t\"departmentAddress\":\"Panipat\",\n" +
                        "\t\"departmentCode\":\"CE-01\"\n" +
                        "}"))
                .andExpect(status().isOk());


    }

    @Test
    void getDepartmentById() throws Exception {
        Mockito.when(departmentService.getDepartmentById(1L)).thenReturn(department);

        mockMvc.perform(get("/departments/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departmentName").value(department.getDepartmentName()));

    }


}