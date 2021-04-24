package com.mycompany.controller;

import com.mycompany.entity.Employee;
import com.mycompany.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Test
    public void shouldBeReturnSuccessWhenTryHealth() throws Exception {
        //Arrange
        mockMvc.perform(
                get("/company/api/employee/health")) //Act
                .andExpect(status().isOk())//Assert
                .andExpect(content().string("Success"));//Assert
    }

    @Test
    public void shouldBeReturnOkWhenTryToGeTAll() throws Exception {
        //Arrange
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new EmployeeDummyUno());
        when(employeeService.getAll()).thenReturn(employeeList);

        //Act
        MockHttpServletResponse response = mockMvc.perform(get("/company/api/employee/all")
                .contentType("application/json"))
                .andReturn().getResponse();
        //Assert
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

    }

    @Test
    public void shouldBeReturnAllEmployeesWhenTryAll() throws Exception {
        //Arrange
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new EmployeeStub());
        String jsonResponse = "[{\"id\":\"1\",\"fullName\":\"Jeff Sutherland\",\"salary\":100.0}]";
        when(employeeService.getAll()).thenReturn(employeeList);

        //Act
        MockHttpServletResponse response = mockMvc.perform(get("/company/api/employee/all")
                .contentType("application/json"))
                .andReturn().getResponse();
        //Assert
        assertThat(response.getContentAsString()).isEqualTo(jsonResponse);
    }

    @Test
    public void shouldBeReturnOkWhenTryToGetEmployeeById() throws Exception {
        //Arrange
        List<Employee> employeeList = new ArrayList<>();
        EmployeeStub employee = new EmployeeStub();
        String jsonResponse = "{\"id\":\"1\",\"fullName\":\"Jeff Sutherland\",\"salary\":100.0}";
        when(employeeService.getEmployee("1")).thenReturn(java.util.Optional.of(employee));

        //Act
        MockHttpServletResponse response = mockMvc.perform(get("/company/api/employee/1")
                .contentType("application/json"))
                .andReturn().getResponse();
        //Assert
        assertThat(response.getContentAsString()).isEqualTo(jsonResponse);

    }
}
