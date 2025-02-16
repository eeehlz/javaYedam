package com.yedam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class EmpApp {
	static EmpDAO dao = new EmpDAO();
	static Employee emp = new Employee();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		boolean run = true;

		while (run) {
			System.out.println("1.등록 2.목록 3.수정 4.삭제 5.조회 6.종료");
			System.out.print("선택 >> ");
			int menu = Integer.parseInt(sc.nextLine());

			switch (menu) {
			case 1: // 등록
				register();
				break;
			case 2: // 목록
				showList();
				break;
			case 3: // 수정
				modify();
				break;
			case 4: // 삭제
				del();
				break;
			case 5: // 조회
				search();
				break;
			case 6: // 종료
				System.out.println("프로그램을 종료합니다.");
				run = false;
				break;
			default:
				System.out.println("메뉴를 확인하시오.");
			}
		}
		System.out.println("end of progs.");
		sc.close();
	}

	private static void register() {
		System.out.print("번호 입력>> ");
		String number = sc.nextLine();
		System.out.print("이름 입력>> ");
		String name = sc.nextLine();
		System.out.print("전화번호 입력>> ");
		String phone = sc.nextLine();
		System.out.print("입사일 입력>> ");
		String hireDate = sc.nextLine();
		System.out.print("급여 입력>> ");
		int salary = Integer.parseInt(sc.nextLine());
		if (dao.registerEmp(new Employee(number, name, phone, hireDate, salary))) {
			System.out.println("등록 성공");
		}
	}

	private static void showList() {
		System.out.println("사번      이름       전화번호");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		List<Employee> result = dao.searchEmp(new Employee());
		for (Employee empl : result) {
			if (empl != null) {
				System.out.println(empl.getNumber() + "\t" + empl.getName() + "\t" + empl.getPhone());
			}
		}
	}

	private static void modify() {
		System.out.print("사번 급여>> ");
		String change = sc.nextLine();
		String number = change.split(" ")[0];
		int salary = Integer.parseInt(change.split(" ")[1]);
		if (dao.modifyEmp(new Employee(number, null, null, null, salary))) {
			System.out.println("수정 성공");
			showList();
		} else {
			System.out.println("수정 실패");
		}
	}

	private static void search() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.print("입사일자>> ");
		String hireDate = sc.nextLine();
		Date date = null;

		try {
			date = sdf.parse(hireDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<Employee> result = dao.searchEmp(new Employee(null, null, null, hireDate, 0));
		System.out.println("번호      이름     입사일자");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		String[] tmp = hireDate.split("-");
		int tmps = Integer.parseInt(tmp[0] + tmp[1] + tmp[2]);
	}

	private static void del() {
		System.out.print("사번>> ");
		String number = sc.nextLine();
		if (dao.deleteEmp(number)) {
			System.out.println("삭제 완료");
			showList();
		} else {
			System.out.println("삭제 실패");
		}
	}

}
