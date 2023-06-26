package com.crud.employee_api.DAO;

import com.crud.employee_api.entity.Employee;

import java.util.List;

public interface EmplyeeDAO {
    public List<Employee> findAll();
}
