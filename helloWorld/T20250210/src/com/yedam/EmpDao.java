package com.yedam;

import java.util.ArrayList;
import java.util.List;

public class EmpDao {
	List<Employee> empList = new ArrayList<>(); // 저장공간

	// init
	public boolean init() {
		empList.add(new Employee("23-11", "홍길동", "943-1234", "2023-09-28", 100));
		empList.add(new Employee("23-12", "김길동", "943-1244", "2023-09-29", 200));
		empList.add(new Employee("23-13", "박길동", "943-1254", "2023-09-30", 300));
		empList.add(new Employee("23-14", "이길동", "943-1254", "2023-10-01", 400));
		empList.add(new Employee("23-15", "최길동", "943-1254", "2023-10-02", 300));
		return true;
	}

	// 등록
	public boolean registerEmp(Employee emp) {
		if (empList.add(emp)) {
			return true;
		}
		return false;
	}

	// 조회
	public List<Employee> searchEmp(Employee emp) {
		if (emp.getId() == null) {
			return empList;
		}
		List<Employee> result = new ArrayList<Employee>();
		for (Employee element : empList) {
			if (element.getRegdate().equals(emp.getRegdate())) {
				result.add(element);
			}
		}
		return result;
	}

	// 수정
	public boolean modifyEmp(Employee emp) {
		for (Employee element : empList) {
			if (element.getId().equals(emp.getId())) {
				element.setSalary(emp.getSalary());
				return true;
			}
		}
		return false;
	}

	// 삭제
	public boolean deleteEmp(String id) {
		for (int i = 0; i < empList.size(); i++) {
			if (empList.get(i).getId().equals(id)) {
				empList.remove(i);
				return true;
			}
		}
		return false;
	}
}
