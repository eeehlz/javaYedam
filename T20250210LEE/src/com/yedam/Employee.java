package com.yedam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {
	private static String number;
	private static String name;
	private static String phone;
	private static Date hireDate;
	private static int salary;

	public Employee() {

	}

	public Employee(String id, String name, String tel) {
		this.number = number;
		this.name = name;
		this.phone = phone;
		this.hireDate = new Date();
		this.salary = 300;
	}

	public Employee(String number, String name, String phone, String hireDate, int salary) {
		this(number, name, phone);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		if (hireDate != null) {
			try {
				date = sdf.parse(hireDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		this.hireDate = date;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [number=" + number + ", name=" + name + ", phone=" + phone + ", hireDate=" + hireDate
				+ ", salary=" + salary + "]";
	}

	public static String empInfo(Employee[] storage) {
		return number + " " + name + " " + phone + " " + hireDate + " " + salary;
	}

	public static String getNumber() {
		return number;
	}

	public static void setNumber(String number) {
		Employee.number = number;
	}

	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		Employee.name = name;
	}

	public static String getPhone() {
		return phone;
	}

	public static void setPhone(String phone) {
		Employee.phone = phone;
	}

	public String getHireDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(hireDate);
	}

	public void setHireDate(Date regdate) {
		this.hireDate = hireDate;
	}

	public static int getSalary() {
		return salary;
	}

	public static void setSalary(int salary) {
		Employee.salary = salary;
	}

}
