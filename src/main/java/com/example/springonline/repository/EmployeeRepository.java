package com.example.springonline.repository;

import com.example.springonline.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("select o from Employee o where o.firstName = ?1") //<- optional
    List<Employee> findByFirstName(String firstName);
    
    List<Employee> findByLastName(String lastName);
}
