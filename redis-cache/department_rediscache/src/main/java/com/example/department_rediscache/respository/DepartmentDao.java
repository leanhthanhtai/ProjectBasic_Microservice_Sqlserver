package com.example.department_rediscache.respository;

import com.example.department_rediscache.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentDao {
    public static final String HASH_KEY = "Department";
    @Autowired
    private RedisTemplate template;

    public Department save(Department department){
        template.opsForHash().put(HASH_KEY,department.getId(),department);
        return department;
    }
    public List<Department> findAll(){

        return template.opsForHash().values(HASH_KEY);
    }

    public Department findDepartmentById(int id){

        return (Department) template.opsForHash().get(HASH_KEY,id);
    }




    public String deleteDepartment(int id) {
        template.opsForHash().delete(HASH_KEY,id);
        return "product removed !!";
    }
}
