package com.yedam;

import java.util.ArrayList;
import java.util.List;


public class EmpDAO {
	List<Employee> empList = new ArrayList<>();

	// 추가 수정 삭제 조회
	// 등록
	public boolean registerEmp(Employee emp) {
		if (empList.add(emp)) {
			return true;
		}
		return false;
	}

	// 조회
	public List<Employee> searchEmp(Employee emp) {
		if (emp.getNumber() == null) {
			return empList;
		}
		List<Employee> result = new ArrayList<Employee>();
		for (Employee element : empList) {
			if (element.getHireDate().equals(emp.getHireDate())) {
				result.add(element);
			}
		}
		return result;
	}

	// 수정
	public boolean modifyEmp(Employee emp) {
		for (Employee element : empList) {
			if (element.getNumber().equals(emp.getNumber())) {
				element.setSalary(emp.getSalary());
				return true;
			}
		}
		return false;
	}

	// 삭제
	public boolean deleteEmp(String id) {
		for (int i = 0; i < empList.size(); i++) {
			if (empList.get(i).getNumber().equals(id)) {
				empList.remove(i);
				return true;
			}
		}
		return false;
	}
}
