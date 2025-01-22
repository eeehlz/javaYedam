package com.yedam;

import java.util.Scanner;

//com.yedam.Todo
public class Todo {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int balance = 0;
		int total = 0;
		int save = 0;
		boolean exit = true;

		while (exit) {
			System.out.println("1.입금 2.출금 3.잔액조회 4.종료");
			System.out.print("메뉴를 선택하세요> ");
			int num = Integer.parseInt(scn.nextLine()); // 문자타입반환
			if (num == 1) { // 입금
				System.out.print("입금액을 입력하세요 > ");
				balance = Integer.parseInt(scn.nextLine());
				total += balance;
				if (total > 100000) {
					System.out.println("초과금액입니다.");
					exit = true;
				}
			}

			if (num == 2) { // 출금
				System.out.printf("현재 잔액은 %d 입니다. 출금 금액을 입력하세요 > ", total);
				balance = Integer.parseInt(scn.nextLine());
				total = total - balance;
				System.out.println("출금완료.");
			} else if (num == 3) { // 잔액조회
				System.out.printf("현재 잔액은 %d 입니다.\n", total);
			} else if (total > 100000) {
				save = total - balance;
				System.out.printf("현재 잔액은 %d 입니다.\n", save);
			}

			else if (num == 4) { // 종료
				System.out.printf("프로그램을 종료합니다.\n");
				exit = false;
			}

		}
		scn.close();
	}
}