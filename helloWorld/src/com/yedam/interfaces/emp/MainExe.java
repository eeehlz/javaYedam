package com.yedam.interfaces.emp;

import java.util.Scanner;

public class MainExe {

	public static void main(String[] args) {
		// 스캐너, run
		Scanner sc = new Scanner(System.in);
		boolean run = true;

		// 배열, 컬렉션.
		EmpDAO dao = new EmpListExe();

		while (run) {
			System.out.println("1.추가 2.수정 3.삭제 4.조회 9.종료");
			System.out.print("선택>> ");
			int menu = Integer.parseInt(sc.nextLine());
//			int menu = sc.nextInt();
//			sc.nextLine();

			switch (menu) {
			case 1: // 추가 사원번호, 이름, 전화번호.
				System.out.print("사원번호>> ");
				int empNo = Integer.parseInt(sc.nextLine());
				System.out.print("이름>> ");
				String eName = sc.nextLine();
				System.out.print("전화번호>> ");
				String tel = sc.nextLine();

				if (dao.registerEmp(new Employee(empNo, eName, tel))) {
					System.out.println("등록성공");
				}
				break; // end of case 1.
			case 2: // 수정항목 : 전화번호, 입사일자, 급여. + 사원번호
				System.out.print("사원번호입력>> ");
				empNo = Integer.parseInt(sc.nextLine());
				System.out.print("전화번호>> ");
				tel = sc.nextLine();
				System.out.print("입사일자>> ");
				String hdate = sc.nextLine();
				if (hdate.equals("")) {
					hdate = "1900-01-01"; // 엔터치고 넘어가면
				}
				System.out.print("급여>> ");
				String salString = sc.nextLine();
				if (salString.equals("")) {
					salString = "0";
				}
				int sal = Integer.parseInt(salString);

				if (dao.modifyEmp(new Employee(empNo, "", tel, hdate, sal))) {
					System.out.println("수정완료");
				}
				break; // case 2 종료

			case 3: // 삭제.
				System.out.print("사원번호입력>> ");
				empNo = Integer.parseInt(sc.nextLine());
				if (dao.removeEmp(empNo)) {
					System.out.println("삭제완료");
				}
				break;
			case 4: // 목록. 조회조건(급여 이상)
//				System.out.print("조회 급여조건>> ");
//				sal = Integer.parseInt(sc.nextLine());
				System.out.print("조회 이름조건>> ");
				eName = sc.nextLine();

				Employee emp = new Employee();
				emp.setEmpName(eName);
				// 조회결과
				Employee[] result = dao.search(emp);
				// 출력
				System.out.println("사번   이름    연락처     급여");
				System.out.println("--------------------------");
				for (Employee empl : result) {
					if (empl != null) {
						System.out.println(empl.empInfo());
					}
				}
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				run = false;
				break;
			default:
				System.out.println("메뉴를 확인하세요.");
			}
		}
		System.out.println("end of prog.");
		sc.close();
	}

}
