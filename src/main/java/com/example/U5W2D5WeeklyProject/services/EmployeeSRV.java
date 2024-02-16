package com.example.U5W2D5WeeklyProject.services;


import com.example.U5W2D5WeeklyProject.entities.Employee;
import com.example.U5W2D5WeeklyProject.exceptions.UUIDNotFoundException;
import com.example.U5W2D5WeeklyProject.payloads.EmployeeDTO;
import com.example.U5W2D5WeeklyProject.repositories.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EmployeeSRV {
    @Autowired
    private EmployeeDAO employeeDAO;

    public Page<Employee> getEmployees(int pageNum, int size, String orderBy) {
        if (size > 100) size = 100;
        Pageable pageable = PageRequest.of(pageNum, size, Sort.by(orderBy));
        return employeeDAO.findAll(pageable);
    }

    public Employee getEmployeeById(UUID id) {
        return employeeDAO.findById(id).orElseThrow(() -> new UUIDNotFoundException(id));
    }

    public Employee saveEmployee(EmployeeDTO newEmployee) {
        return employeeDAO.save(new Employee(newEmployee.getName(), newEmployee.getSurname(),
                newEmployee.getEmail(), newEmployee.getUsername()));
    }

    public Employee updateEmployeeById(Employee updatedEmployee, UUID id) {
        Employee found = getEmployeeById(id);
        found.setName(updatedEmployee.getName());
        found.setSurname(updatedEmployee.getSurname());
        found.setEmail(updatedEmployee.getEmail());
        found.setUsername(updatedEmployee.getUsername());
        return found;
    }

    public void deleteEmployee(UUID id) {
        Employee found = getEmployeeById(id);
        employeeDAO.delete(found);
    }

}
