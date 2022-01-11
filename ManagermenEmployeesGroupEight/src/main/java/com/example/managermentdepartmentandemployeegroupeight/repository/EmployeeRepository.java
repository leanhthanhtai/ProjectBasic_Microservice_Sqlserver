package com.example.managermentdepartmentandemployeegroupeight.repository;

import com.example.managermentdepartmentandemployeegroupeight.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    public List<Employee>  getEmployeesByIdDepartment(long idDepartment);
    @Modifying
    @Query(value = "SELECT * from Employee where name like %?1% ", nativeQuery = true)
    public List<Employee>  searchEmployeeByName(String name);

}
