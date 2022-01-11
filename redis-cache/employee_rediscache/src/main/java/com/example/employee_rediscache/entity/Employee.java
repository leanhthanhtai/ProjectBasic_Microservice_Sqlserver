package com.example.employee_rediscache.entity;

import lombok.*;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Employee")
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String mssv;
    @Column(name="namsinh")
    private int namSinh;
    @Column(name = "iddepartment")
    private long idDepartment;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMssv() {
        return mssv;
    }
    public void setMssv(String mssv) {
        this.mssv = mssv;
    }
    public int getNamSinh() {
        return namSinh;
    }
    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }
    public long getIdDepartment() {
        return idDepartment;
    }
    public void setIdDepartment(long idDepartment) {
        this.idDepartment = idDepartment;
    }


}
