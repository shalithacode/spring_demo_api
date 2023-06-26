package com.crud.employee_api.rest;

import com.crud.employee_api.DAO.EmployeeDAO;
import com.crud.employee_api.entity.Employee;
import com.crud.employee_api.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> findAll(@PathVariable int id) {

    Employee employee =iEmployeeService.findById(id);
    if (employee == null) throw new RuntimeException("Employee not found id : "+ id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee newEmployee){
        newEmployee.setId(0);
        Employee employee =iEmployeeService.save(newEmployee);
        if (employee == null) throw new RuntimeException("Employee not saved ");
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }


}
