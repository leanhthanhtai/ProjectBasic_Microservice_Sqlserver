package com.example.department_rediscache;

import com.example.department_rediscache.entity.Department;
import com.example.department_rediscache.respository.DepartmentDao;
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
@RequestMapping("/department")
@EnableCaching
public class DepartmentRediscacheApplication {
	@Autowired
	private DepartmentDao dao;

	@PostMapping
	public Department save(@RequestBody Department department) {

		return dao.save(department);
	}

	@GetMapping
	public List<Department> getAllDepartment() {

		return dao.findAll();
	}

	@GetMapping("/{id}")
	@Cacheable(key = "#id", value = " Department")
	public Department findDepartment(@PathVariable int id) {

		return dao.findDepartmentById(id);
	}
	@DeleteMapping("/{id}")
	@CacheEvict(key = "#id", value = " Department")
	public String remove(@PathVariable int id)   {

		return dao.deleteDepartment(id);
	}
	public static void main(String[] args) {

		SpringApplication.run(DepartmentRediscacheApplication.class, args);
	}
}
