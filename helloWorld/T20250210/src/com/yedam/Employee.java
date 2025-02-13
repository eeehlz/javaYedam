package com.yedam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {
	private String id;
	private String name;
	private String tel;
	private Date regdate;
	private int salary;

	public Employee() {
		
	}
	
	public Employee(String id, String name, String tel) {
		this.id = id;
		this.name = name;
		this.tel = tel;
		this.regdate = new Date();
		this.salary = 250;
	}
	public Employee(String id, String name, String tel, String regdate, int salary) {
		this(id, name, tel);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		if(regdate != null) {
			try {
				date = sdf.parse(regdate);
			} catch(ParseException e) {
				e.printStackTrace();
			}
		}
		this.regdate = date;
		this.salary = salary;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getRegdate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(regdate);
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", tel=" + tel + ", regdate=" + regdate + ", salary=" + salary
				+ "]";
	}
}
