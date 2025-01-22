package com.yedam;

import java.util.Iterator;
import java.util.Scanner;

public class Forloop2 {

	public static void main(String[] args) {
//		String[] infoAry = "홍길동,80,85".split(",");
//		System.out.println(infoAry[0]);
//		System.out.println(infoAry[1]);
//		System.out.println(infoAry[2]);
//		System.out.println(Integer.parseInt(infoAry[1]));
//		System.out.println(Integer.parseInt("80") * Integer.parseInt("70"));
//	String[] studentAry = new String[3];
//	boolean run = true;

//		System.out.println("이름,점수 값을 입력");
//		String userVal = sc.nextLine();
//		String[] infoAry = userVal.split(",");
//
//		System.out.printf("이름은 %s 이고 점수는 %s 입니다.", infoAry[0], infoAry[1]);
		Scanner sc = new Scanner(System.in);

		String[] studentAry = new String[100];
		studentAry[0] = "홍길동,80";
		studentAry[1] = "김민수,70";
		studentAry[2] = "박우식,85";
		boolean run = true;

		while (run) {
			System.out.println("1.학생,점수등록 2.최고점수,3.학생입력(한건씩), 4.조희, 9.종료");
			System.out.print("선택하세요 >>");
			int menu = Integer.parseInt(sc.nextLine());

			switch (menu) {
			case 1:
				for (int i = 0; i < studentAry.length; i++) {
					System.out.print("학생이름, 점수를 등록하세요 >");
//					String value = sc.nextLine();
//					studentAry = value.split(",");
//					System.out.printf("%s,%s\n", studentAry[0], studentAry[1]);
					studentAry[i] = sc.nextLine();
					// studentAry[i].split(",") = [이혁진,80]
				}
				System.out.println("등록완료!");
				break;

			case 2:
				int max = 0;
				for (int i = 0; i < studentAry.length; i++) {
					if (studentAry[i] != null) { // null 값이 아닐때 아래 코드 실행
						int temp = Integer.parseInt(studentAry[i].split(",")[1]);
						if (max < temp) {
							max = temp;
						}
					}
				}
				System.out.printf("최고점수는 %d\n", max);
				break;

			case 3:
				System.out.print("이름,점수 값을 입력하세요 >");
				for (int i = 0; i < studentAry.length; i++) {
					if (studentAry[i] == null) {
						studentAry[i] = sc.nextLine();
						break;
					}
				}
				break;

			case 4:
				System.out.print("이름을 입력하세요 >>");
				String searchName = sc.nextLine();

				for (int i = 0; i < studentAry.length; i++) {
					if (studentAry[i] != null) {
						if (studentAry[i].split(",")[0].equals(searchName)) { // 문자열 비교할떈 .equals()
							System.out.printf("%s의 점수는 %s입니다.\n", studentAry[i].split(",")[0],
									studentAry[i].split(",")[1]);
							break;
						}
					} else {
						System.out.println("X");
					}
				}

				break;

			case 9:
				System.out.println("프로그램을 종료합니다.");
				run = false;
				break;
			default:
				System.out.println("메뉴를 다시 선택하세요.");
			}
		} // end of while
//		System.out.println("end of prog.");
		sc.close();
	}// end of main
}// end of class
