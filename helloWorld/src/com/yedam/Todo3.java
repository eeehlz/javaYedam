package com.yedam;

import java.util.Scanner;

public class Todo3 {

	public static void main(String[] args) {

		boolean run = true;
		Scanner sc = new Scanner(System.in);

		String[][] friendAry = new String[100][3];
		friendAry[0] = new String[] { "이혁진", "010-4444-2222", "남" };
		friendAry[1] = new String[] { "홍길동", "010-4333-2222", "남" };
		friendAry[2] = new String[] { "김길동", "010-1111-2222", "여" };

		while (run) {
			System.out.println("1.목록 2.등록 3.성별조회 6.종료");
			System.out.print("선택 >");
			int menu = Integer.parseInt(sc.nextLine());

			switch (menu) {
			case 1: // 목록
				for (int i = 0; i < friendAry.length; i++) {
					if (friendAry[i] != null && friendAry[i][0] != null) {
						System.out.printf("이름:%s 번호:%s 성별:%s\n", friendAry[i][0], friendAry[i][1], friendAry[i][2]);
					}
				}
				break;

			case 2: // 등록
				System.out.print("이름 입력 >>");
				String name = sc.nextLine();
				System.out.print("번호 입력 >>");
				String phone = sc.nextLine();
				System.out.print("성별 입력 >>");
				String gender = sc.nextLine();

				for (int i = 0; i < friendAry.length; i++) {
					if (friendAry[i] != null && friendAry[i][0] == null) {
						friendAry[i] = new String[] { name, phone, gender };
						break;
					}
				}
				break;

			case 3: // 조회(성별)
				System.out.print("이름입력 >>");
				String searchName = sc.nextLine();
				for (int i = 0; i < friendAry.length; i++) {
					if (friendAry[i][0] != null && friendAry[i][0] != null) {
						if (friendAry[i][0].equals(searchName)) {
							System.out.printf("%s의 성별 : %s\n", searchName, friendAry[i][2]);
							break;
						}
					}
				}
				break;

			case 6: // 종료
				System.out.println("프로그램 종료");
				run = false;
				break;
			default:
				System.out.println("다시 시작하세요.");
			}
		}

	}
}
