package com.example.springonline;

import com.example.springonline.domain.Employee;
import com.example.springonline.repository.EmployeeJpaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringOnlineApplication {

	@Bean
	public CommandLineRunner init(EmployeeJpaRepository employeeJpaRepository) {
		return (args -> {
			employeeJpaRepository.save(new Employee("john", "doe"));
			employeeJpaRepository.save(new Employee("somchai", "dodee"));
			employeeJpaRepository.save(new Employee("john", "doo"));
		});
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringOnlineApplication.class, args);
	}

}
