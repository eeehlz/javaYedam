package com.yedam.interfaces.emp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/*
 * 컬렉션 활용
 */
public class EmpListExe implements EmpDAO {

	List<Employee> empList = new ArrayList<Employee>(); // 저장공간

	public EmpListExe() {
		empList.add(new Employee(1001, "홍길동", "432-1234"));
		empList.add(new Employee(1011, "박길동", "432-3245"));
		empList.add(new Employee(1021, "김길동", "432-4353"));
		empList.add(new Employee(1010, "박사장", "432-7777", "2000-01-03", 500));
	}

	@Override
	public boolean registerEmp(Employee emp) {
		return empList.add(emp); // 등록
	}

	@Override
	public boolean modifyEmp(Employee emp) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for (int i = 0; i < empList.size(); i++) {
			// 사원번호 비교
			if (empList.get(i).getEmpNo() == emp.getEmpNo()) {
				// 연락처값이 ""이 아닐때 변경
				if (!emp.getTelNo().equals("")) {
					empList.get(i).setTelNo(emp.getTelNo());
				}
				try {
					// 값을 변경안하려고 엔터("")일 경우 1900-01-01
					if (!emp.getHireDate().equals(sdf.parse("1900-01-01"))) {
						empList.get(i).setHireDate(emp.getHireDate());
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}

				if (emp.getSalary() != 0) {
					empList.get(i).setSalary(emp.getSalary());
				}
				return true; // 수정완료
			}
		}
		return false; // 수정못함
	}

	@Override
	public boolean removeEmp(int empNo) {
		for (int i = 0; i < empList.size(); i++) {
			if (empList.get(i).getEmpNo() == empNo) {
				empList.remove(i); // 삭제
				return true;
			}
		}
		return false;
	}

	@Override
	public Employee[] search(Employee emp) {
		Employee[] result = new Employee[10];
		int idx = 0;
		

		for (int i = 0; i < empList.size(); i++) {

			// indexOf
			if (empList.get(i).getEmpName().indexOf(emp.getEmpName())>-1) {
				result[idx] = empList.get(i);
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