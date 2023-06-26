package com.crud.employee_api.DAO;

import com.crud.employee_api.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeJpaImpl implements EmployeeDAO {

    private EntityManager entityManager;
    @Autowired
    public EmployeeJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee ", Employee.class);

        return query.getResultList();
    }
}
