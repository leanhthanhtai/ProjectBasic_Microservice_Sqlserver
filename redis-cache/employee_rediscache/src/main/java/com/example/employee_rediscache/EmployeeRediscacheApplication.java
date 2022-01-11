package com.example.employee_rediscache;

import com.example.employee_rediscache.entity.Employee;
import com.example.employee_rediscache.respository.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/employee")
@EnableCaching
public class EmployeeRediscacheApplication {
	@Autowired
	private EmployeeDao dao;

	@PostMapping
	public Employee save(@RequestBody Employee employee) {

		return dao.save(employee);
	}

	@GetMapping
	public List<Employee> getAllEmployees() {

		return dao.findAll();
	}

	@GetMapping("/{id}")
	@Cacheable(key = "#id", value = " Employee")
	public Employee findEmployee(@PathVariable int id) {

		return dao.findEmployeeById(id);
	}
	@DeleteMapping("/{id}")
	@CacheEvict(key = "#id", value = " Employee")
	public String remove(@PathVariable int id)   {

		return dao.deleteEmployee(id);
	}
	public static void main(String[] args) {

		SpringApplication.run(EmployeeRediscacheApplication.class, args);
	}
}
