package com.crud.employee_api.service;

import com.crud.employee_api.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IEmployeeService {

        List<Employee> findAll();
        Employee findById(int id);
        public Employee save(Employee employee);
        public void deleteById(int id);
}
