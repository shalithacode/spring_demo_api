package com.crud.employee_api.service;

import com.crud.employee_api.DAO.EmployeeDAO;
import com.crud.employee_api.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService implements IEmployeeService{

    private EmployeeDAO emplyeeDAO;

    @Autowired
    public EmployeeService(EmployeeDAO emplyeeDAO) {
        this.emplyeeDAO = emplyeeDAO;
    }
    @Override
    public List<Employee> findAll() {
        List<Employee> employees = emplyeeDAO.findAll();
        return employees;
    }

    @Override
    public Employee findById(int id) {
        return emplyeeDAO.findById(id);
    }

    @Transactional
    @Override
    public Employee save(Employee employee) {
        return emplyeeDAO.save(employee);
    }
    @Transactional
    @Override
    public void deleteById(int id) {
        emplyeeDAO.deleteById(id);
    }
}
