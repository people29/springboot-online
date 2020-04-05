package com.example.springonline.service;

import com.example.springonline.domain.Employee;
import com.example.springonline.repository.EmployeeJpaRepository;
import com.example.springonline.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeJpaRepository employeeJpaRepository;

    public List<Employee> listAllEmployee() {
        return employeeJpaRepository.findAll();
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee findById(Integer id) {
//        return employeeJpaRepository.findById(id);
        return employeeRepository.findById(id).orElseThrow(()-> new RuntimeException("data not found"));
    }

    public void save(Employee employee) {
//        employeeJpaRepository.save(employee);
        employeeRepository.save(employee);
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

    public List<Employee> findByFirstName(String firstName) {
        return employeeRepository.findByFirstName(firstName);
//        return employeeJpaRepository.findByFirstName(firstName);
    }

    public List<Employee> findByNativeQuery(String firstName) {
        return employeeJpaRepository.findByNativeQuery(firstName);
    }

    public List<Employee> findByLastName(String lastName) {
        return employeeRepository.findByLastName(lastName);
    }
}
