package com.example.U5W2D5WeeklyProject.services;


import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.U5W2D5WeeklyProject.entities.Employee;
import com.example.U5W2D5WeeklyProject.exceptions.UUIDNotFoundException;
import com.example.U5W2D5WeeklyProject.payloads.EmployeeDTO;
import com.example.U5W2D5WeeklyProject.repositories.EmployeeDAO;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
public class EmployeeSRV {
    @Autowired
    private EmployeeDAO employeeDAO;
    @Autowired
    private Cloudinary cloudinaryUploader;

    public Page<Employee> getEmployees(int pageNum, int size, String orderBy) {
        if (size > 100) size = 100;
        Pageable pageable = PageRequest.of(pageNum, size, Sort.by(orderBy));
        return employeeDAO.findAll(pageable);
    }

    public Employee getEmployeeById(UUID id) {
        return employeeDAO.findById(id).orElseThrow(() -> new UUIDNotFoundException(id));
    }

    public Employee saveEmployee(EmployeeDTO newEmployee) {
        return employeeDAO.save(new Employee(newEmployee.getUsername(), newEmployee.getName(),
                newEmployee.getSurname(), newEmployee.getEmail()));
    }


    public Employee updateEmployeeById(EmployeeDTO updatedEmployee, UUID id) {

        Employee found = getEmployeeById(id);
        found.setName(updatedEmployee.getName());
        found.setSurname(updatedEmployee.getSurname());
        found.setEmail(updatedEmployee.getEmail());
        found.setUsername(updatedEmployee.getUsername());
        employeeDAO.save(found);
        return found;
    }

    public void deleteEmployee(UUID id) {
        Employee found = getEmployeeById(id);
        employeeDAO.delete(found);
    }


    public String uploadImageForAuthor(MultipartFile image, UUID id) throws IOException {
        String url = (String) cloudinaryUploader.uploader().upload(image.getBytes(),
                ObjectUtils.emptyMap()).get("url");

        Employee found = this.getEmployeeById(id);
        found.setImage(String.valueOf(url));
        employeeDAO.save(found);
        return url;
    }

}
