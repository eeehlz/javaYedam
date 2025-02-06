package com.yedam.interfaces.emp;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/*
 * 배열활용
 */
public class EmpAryExe implements EmpDAO {

	Employee[] employees = new Employee[10]; // 저장공간.

	@Override
	public boolean registerEmp(Employee emp) {
		for (int i = 0; i < employees.length; i++) {
			if (employees[i] == null) {
				employees[i] = emp;
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean modifyEmp(Employee emp) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for (int i = 0; i < employees.length; i++) {
			// 사원번호 비교
			if (employees != null && employees[i].getEmpNo() == emp.getEmpNo()) {
				// 연락처값이 ""이 아닐때 변경
				if (!emp.getTelNo().equals("")) {
					employees[i].setTelNo(emp.getTelNo());
				}
				try {
					// 값을 변경안하려고 엔터("")일 경우 1900-01-01
					if (emp.getHireDate().equals(sdf.parse("1900-01-01"))) {
						employees[i].setHireDate(emp.getHireDate());
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}

				if (emp.getSalary() != 0) {
					employees[i].setSalary(emp.getSalary());
				}
				return true; // 수정완료
			}
		}
		return false; // 수정못함

	}

	@Override
	public boolean removeEmp(int empNo) {
		for (int i = 0; i < employees.length; i++) {
			if (employees[i] != null && employees[i].getEmpNo() == empNo) {
				employees[i] = null; // 삭제
				return true;
			}
		}
		return false;
	}

	@Override
	public Employee[] search(Employee emp) {
		Employee[] result = new Employee[10];
		int idx = 0;
		String name = emp.getEmpName();
		for (int i = 0; i < employees.length; i++) {
			// indexOf
			if (employees[i] != null && employees[i].getEmpName().indexOf(name) > -1) {
				result[idx] = employees[i];
				idx++;
			}

//			if (empList.get(i).getSalary() >= emp.getSalary()) {
//				result[idx] = empList.get(i);
//				idx++;
//			}
		}
		return result;
	}
}
