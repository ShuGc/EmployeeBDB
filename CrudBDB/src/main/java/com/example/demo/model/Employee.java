package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "Employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idEmp;
	@Column(name = "fullname",nullable=false)
	private String fullname;
	@Column(name = "function",nullable=false)
	private String function;
	@Column(name = "id_boss",nullable=false)
	private long id_boss;	
	
	public Employee(){}
	
	public Employee(long idEmp, String fullname, String function, long id_boss) {
		super();
		this.idEmp = idEmp;
		this.fullname = fullname;
		this.function = function;
		this.id_boss = id_boss;
	}

	public long getIdEmp() {
		return idEmp;
	}

	public void setIdEmp(long idEmp) {
		this.idEmp = idEmp;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public long getId_boss() {
		return id_boss;
	}

	public void setId_boss(long id_boss) {
		this.id_boss = id_boss;
	}

}
