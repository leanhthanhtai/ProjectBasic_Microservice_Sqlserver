package com.example.managermentdepartmentandemployeegroupeight.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Columns;

import javax.persistence.*;

@Entity
@Data
@Setter
@Getter
public class Employee {
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
