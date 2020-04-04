package com.example.springonline.service;

import com.example.springonline.domain.Employee;
import com.example.springonline.repository.EmployeeJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeJpaRepository employeeJpaRepository;

    public List<Employee> listAllEmployee() {
        return employeeJpaRepository.findAll();
    }

    public Employee findById(Integer id) {
        return employeeJpaRepository.findById(id);
    }

    public void save(Employee employee) {
        employeeJpaRepository.save(employee);
    }

    public Employee update(Integer id, Employee employee) {
        Employee emp = findById(id);
        if (emp == null) {
            throw new RuntimeException("Not found employee");
        }

        emp.setFirstName(employee.getFirstName());
        emp.setLastName(employee.getLastName());
        employeeJpaRepository.save(emp);

        return emp;
    }

    public void delete(Integer id) {
        Employee emp = findById(id);
        if (emp == null) {
            throw new RuntimeException("Not found employee");
        }

        employeeJpaRepository.delete(emp);
    }
}
