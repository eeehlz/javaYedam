package com.yedam;

import java.util.Scanner;

/*
 * 학생점수 입력 받아서 배열저장.
 * 최고점수, 평균, 합계점수 출력.
 * */
public class ForLoopExe1 {

	public static void main(String[] args) {
		boolean run = true;
		int sum = 0;
		Scanner sc = new Scanner(System.in);
		// 정수배열. []
		int[] scores = new int[3];

		while (run) {
			System.out.println("1.학생점수입력 2.최고점수 3.평균 4.합계 5.종료");
			System.out.print("선택하세요> ");
			int menu = Integer.parseInt(sc.nextLine());

			switch (menu) {
			case 1:
				for (int i = 0; i < scores.length; i++) {
					System.out.print("점수를 입력하세요.> ");
					scores[i] = Integer.parseInt(sc.nextLine());
				}
				System.out.println("입력완료");
				break;
			case 2:
				int max = 0;
				for (int i = 0; i < scores.length; i++) {
					if (max < scores[i]) {
						max = scores[i];
					}
				}
				System.out.printf("최고점수는 %d 입니다.\n", max);
				break;

			case 3:

				double avg = 0;
				for (int i = 0; i < scores.length; i++) {
					sum += scores[i];
				}
				avg = (sum / scores.length);
				System.out.printf("합계는 %d 평균점수는 %.1f 입니다.", sum, avg);
				break;
			case 4:
				for (int i = 0; i < scores.length; i++) {
					sum += scores[i];
				}
				;
				System.out.printf("합계는 %d 입니다.", sum);
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				run = false;
				break;
			default:
				System.out.println("메뉴를 다시 선택하세요.");
			}
		}
		System.out.println("end of prog.");

		sc.close();
	}
}
