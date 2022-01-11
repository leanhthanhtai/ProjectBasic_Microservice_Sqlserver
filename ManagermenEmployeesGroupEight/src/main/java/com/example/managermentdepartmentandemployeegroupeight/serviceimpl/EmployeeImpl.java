package com.example.managermentdepartmentandemployeegroupeight.serviceimpl;

import com.example.managermentdepartmentandemployeegroupeight.entity.Employee;

import java.util.List;

public interface EmployeeImpl {
    public Employee[] getListEmployee();
    public Employee getEmployee(long id);
    public Boolean deleteEmployee(long id);
    public Boolean updateEmployee(Employee employee);
    public Boolean addEmployee(Employee employee);
    public Employee[] searchEmployeeByName(String name);
    public Employee[] searchEmployeeById(long idDepartment);
}
