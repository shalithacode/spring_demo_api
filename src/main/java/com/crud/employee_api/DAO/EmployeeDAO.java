package com.crud.employee_api.DAO;

import com.crud.employee_api.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> findAll();
}
