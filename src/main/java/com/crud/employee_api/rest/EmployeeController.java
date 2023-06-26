package com.crud.employee_api.rest;

import com.crud.employee_api.DAO.EmployeeDAO;
import com.crud.employee_api.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private EmployeeDAO emplyeeDAO;

    @Autowired
    public EmployeeController(EmployeeDAO emplyeeDAO) {
        this.emplyeeDAO = emplyeeDAO;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> findAll() {
        List<Employee> employees = emplyeeDAO.findAll();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}
