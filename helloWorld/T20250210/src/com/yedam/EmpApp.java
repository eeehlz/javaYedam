package com.yedam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class EmpApp {
	private static EmpDao dao = new EmpDao();
    private static Scanner sc = new Scanner(System.in);
    
	public static void main(String[] args) {
		boolean run = true;
		dao.init();
		while (run) {
			System.out.println("1.등록 2.목록 3.수정(급여) 4.삭제 5.조회(조건: 입사일자) 6.종료");
			System.out.print(">> ");
			int menu = Integer.parseInt(sc.nextLine());

			switch (menu) {
			case 1:
				reg();
				break;
			case 2:
				list();
				break;
			case 3:
				mod();
				break;
			case 4:
				del();
				break;
			case 5:
				regList();
				break;
			case 6:
				run = false;
				System.out.println("종료됩니다.");
				break;
			default:
				System.out.println("다시 입력하세요");
			}
		}
	}
	private static void reg() {
		System.out.print("사번입력>> ");
		String id = sc.nextLine();
		System.out.print("이름입력>> ");
		String name = sc.nextLine();
		System.out.print("전화번호입력>> ");
		String tel = sc.nextLine();
		System.out.print("입사일입력>> ");
		String regdate = sc.nextLine();
		System.out.print("급여입력>> ");
		int salary = Integer.parseInt(sc.nextLine());
		if (dao.registerEmp(new Employee(id, name, tel, regdate, salary))) {
			System.out.println("등록 성공");
		}
	}
	
	private static void list() {
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("사번      이름       전화번호");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		List<Employee> result = dao.searchEmp(new Employee());
		for (Employee empl : result) {
			if (empl != null) {
				System.out.println(empl.getId() + "\t" + empl.getName() + "\t" + empl.getTel());
			}
		}
	}
	
	private static void mod() {
		System.out.print("사번 급여>> ");
		String change = sc.nextLine();
		String id = change.split(" ")[0];
		int salary = Integer.parseInt(change.split(" ")[1]);
		if (dao.modifyEmp(new Employee(id, null, null, null, salary))) {
			System.out.println("수정 완료");
			list();
		} else {
			System.out.println("수정 실패");
		}
	}
	
	private static void del() {
		System.out.print("사번>> ");
		String id = sc.nextLine();
		if (dao.deleteEmp(id)) {
			System.out.println("삭제 완료");
			list();
		} else {
			System.out.println("삭제 실패");
		}
	}
	
	private static void regList() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.print("입사일자>> ");
		String regdate = sc.nextLine();
		Date date = null;

		try {
			date = sdf.parse(regdate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<Employee> result = dao.searchEmp(new Employee(null, null, null, regdate, 0));
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("사번      이름       입사일자");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		String[] tmp = regdate.split("-");
		int _tmp = Integer.parseInt(tmp[0] + tmp[1] + tmp[2]);
		for(Employee emp: result) {
			String[] dates = emp.getRegdate().split("-");
			int _dates = Integer.parseInt(dates[0] + dates[1] + dates[2]);
			if(_tmp <= _dates) {
				System.out.println(emp.getId() + "\t" + emp.getName() + "\t" + emp.getRegdate());
			}
		}
	}
}