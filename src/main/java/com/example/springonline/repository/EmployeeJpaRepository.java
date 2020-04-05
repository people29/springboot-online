package com.example.springonline.repository;

import com.example.springonline.domain.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class EmployeeJpaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Employee employee) {
        entityManager.persist(employee);
    }

    public List<Employee> findAll() {
        return entityManager.createQuery("from Employee").getResultList();
    }

    public Employee findById(Integer id) {
        return entityManager.find(Employee.class, id);
    }

    @Transactional
    public void delete(Employee employee) {
        entityManager.remove(employee);
    }

    public List<Employee> findByFirstName(String firstName) {
        Query query = entityManager.createQuery("from Employee e where e.firstName = :firstName");
        query.setParameter("firstName", firstName);

        return query.getResultList();
    }

    public List<Employee> findByNativeQuery(String firstName) {
        System.out.println("firstName" + firstName);
        Query query = entityManager.createNativeQuery("select * from employee", Employee.class);

        return query.getResultList();
    }
}
