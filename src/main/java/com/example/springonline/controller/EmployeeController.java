package com.example.springonline.controller;

import com.example.springonline.domain.Employee;
import com.example.springonline.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> findAll() {
//        return employeeService.listAllEmployee();
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Integer id) {
        Employee employee = employeeService.findById(id);
        return  employee;
    }

    @PostMapping
    public void create(@RequestBody Employee employee) {
        employeeService.save(employee);
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Integer id, @RequestBody Employee employee) {
        return employeeService.update(id, employee);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        employeeService.delete(id);
    }

    @GetMapping("/firstName/{firstName}")
    public List<Employee> findByFirstName(@PathVariable String firstName) {
        return employeeService.findByFirstName(firstName);
    }

    @GetMapping("/nativeQuery")
    public List<Employee> findByNativeQuery(@RequestParam(name = "firstName") String firstName) {
        return employeeService.findByNativeQuery(firstName);
    }

}
