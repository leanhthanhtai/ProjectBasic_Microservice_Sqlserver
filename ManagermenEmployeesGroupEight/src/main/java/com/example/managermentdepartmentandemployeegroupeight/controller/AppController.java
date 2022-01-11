package com.example.managermentdepartmentandemployeegroupeight.controller;

import com.example.managermentdepartmentandemployeegroupeight.entity.Employee;
import com.example.managermentdepartmentandemployeegroupeight.serviceimpl.EmployeeImpl;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppController {

    @Autowired
    EmployeeImpl employeeImpl;


    @GetMapping("employee")
    public Employee[] outputListEmployee(){
        Employee[] lst = employeeImpl.getListEmployee();
        if(lst.length > 0){
            return lst;
        }
        return null;
    }


    @DeleteMapping("employee/{id}")
    public String outputDeleteEmployee(@PathVariable long id){
        if(employeeImpl.deleteEmployee(id)){
            return "Delete Success Employee!";
        }
        return "Delete Fail Employee!";
    }


    @PutMapping("employee")
    public String outputUpdateEmployee(@RequestBody Employee employee){
        if(employeeImpl.updateEmployee(employee)){
            return "Update Success Employee!";
        }
        return "Delete Fail Employee!";
    }


    @PostMapping("employee")
    public String outputAddEmployee(@RequestBody Employee employee){
        employee.setId(0);
        if(employeeImpl.addEmployee(employee)){
            return "Add Success Employee!";
        }
        return "Add Fail Employee!";
    }

    @Retry(name="basic")
    @RateLimiter(name = "basicExample")
    @GetMapping("employee/{name}")
    public Employee[] outputSearchEmployee(@PathVariable String name){

        return employeeImpl.searchEmployeeByName(name);
    }



    @GetMapping("employees/{idDepartment}")
    public Employee[] outputListEmployeeByIdDepartmnet(@PathVariable long idDepartment){
        return employeeImpl.searchEmployeeById(idDepartment);
    }
}
