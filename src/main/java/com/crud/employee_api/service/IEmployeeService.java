package com.crud.employee_api.service;

import com.crud.employee_api.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IEmployeeService {

        List<Employee> findAll();
}
