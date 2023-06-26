package com.crud.employee_api.DAO;

import com.crud.employee_api.entity.Employee;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeJpaImpl implements EmplyeeDAO{

    private EntityManager entityManager;
    @Autowired
    public EmployeeJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        return null;
    }
}
