package com.example.managermentdepartmentandemployeegroupeight.service;

import com.example.managermentdepartmentandemployeegroupeight.entity.Employee;
import com.example.managermentdepartmentandemployeegroupeight.repository.EmployeeRepository;
import com.example.managermentdepartmentandemployeegroupeight.serviceimpl.EmployeeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements EmployeeImpl {

    @Autowired
    EmployeeRepository employeeRepository;


    @Override
    public Employee[] getListEmployee() {
        List<Employee> lst = employeeRepository.findAll();
        Employee[] employees = new Employee[20];
        int i=0;
        for (Employee e : lst){
            employees[i] = e;
            i++;
        }
        return  employees;
    }

    @Override
    public Employee getEmployee(long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public Boolean deleteEmployee(long id) {
        Employee employee = getEmployee(id);
        if(employee !=null){
            employeeRepository.delete(employee);
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateEmployee(Employee employee) {
        if(employee !=null){
            employeeRepository.saveAndFlush(employee);
            return true;
        }
        return false;
    }

    @Override
    public Boolean addEmployee(Employee employee) {
        if(employee != null){
            employeeRepository.save(employee);
            return true;
        }
        return false;
    }

    @Override
    public Employee[] searchEmployeeByName(String name) {
        List<Employee> lst = employeeRepository.searchEmployeeByName(name);
        Employee[] employees = new Employee[8];
        int i=0;
        for (Employee e : lst){
            employees[i] = e;
            i++;
        }
        return  employees;
    }

    @Override
    public Employee[] searchEmployeeById(long idDepartment) {
        List<Employee> lst = employeeRepository.getEmployeesByIdDepartment(idDepartment);
        Employee[] employees = new Employee[8];
        int i=0;
        for (Employee e : lst){
            employees[i] = e;
            i++;
        }
        return  employees;
    }
}
