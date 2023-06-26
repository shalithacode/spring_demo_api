package com.crud.employee_api.rest;

import com.crud.employee_api.DAO.EmployeeDAO;
import com.crud.employee_api.entity.Employee;
import com.crud.employee_api.service.IEmployeeService;
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

private IEmployeeService iEmployeeService;

@Autowired
    public EmployeeController(IEmployeeService EmployeeService) {
        this.iEmployeeService = EmployeeService;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> findAll() {

        return new ResponseEntity<>(iEmployeeService.findAll(), HttpStatus.OK);
    }
}
