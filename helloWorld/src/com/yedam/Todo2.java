package com.yedam;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

/* 
 * 친구정보관리 앱 v.1
 * 이름,연락처,성별(남/여) => 홍길동, 01066662222, 남
 * 1. 목록 (목록,연락처,성별) 2.등록 3.조회(성별) 4.삭제 5.수정
 * String[] friendAry 크기는 100개 ;
 */
public class Todo2 {

	public static void main(String[] args) {
		String[] friendAry = new String[100];
		boolean run = true;
		Scanner sc = new Scanner(System.in);

		friendAry[0] = "이혁진,01066448150,남자";
		friendAry[1] = "임은지,01032532120,여자";
		friendAry[2] = "홍길동,01064549760,남자";

		while (run) {
			System.out.println("1.목록 2.등록 3.성별조회 4.삭제 5.수정 6.종료");
			System.out.print("선택 >");
			int menu = Integer.parseInt(sc.nextLine());

			switch (menu) {
			case 1: // 목록
				for (int i = 0; i < friendAry.length; i++) {
					if (friendAry[i] != null) {
						System.out.println(friendAry[i]);
					}
				}
				break;

			case 2: // 등록
				System.out.println("이름,연락처,성별 을 입력하세요.");

				for (int i = 0; i < friendAry.length; i++) {
					if (friendAry[i] == null) {
						friendAry[i] = sc.nextLine();
						break;
					}

				}
				break;

			case 3: // 조회 (성별)
				for (int i = 0; i < friendAry.length; i++) {
					if (friendAry[i] != null) {
						System.out.printf("이름:%s\n", friendAry[i].split(",")[0]);
					}
				}
				System.out.print("성별조회 이름을 입력하세요 >>");
				String searchName = sc.nextLine();
				for (int i = 0; i < friendAry.length; i++) {
					if (friendAry[i] != null) {
						if (friendAry[i].split(",")[0].equals(searchName)) {
							System.out.printf("%s의 성별 : %s\n", searchName, friendAry[i].split(",")[2]);
							break;
						}
					}
				}
				break;

			case 4: // 삭제
				System.out.print("삭제할 이름> ");
				String delName = sc.nextLine();
				for (int i = 0; i < friendAry.length; i++) {
					if (friendAry[i] != null) {
						if (friendAry[i].split(",")[0].equals(delName)) {
							friendAry[i] = null;
							break;
						}
					}
				}
				break;

			case 5:
				System.out.print("번호 수정할 이름 >");

                String numName = sc.nextLine();
                for (int i = 0; i < friendAry.length; i++) {
                    if (friendAry[i] != null) {
                        if (friendAry[i].split(",")[0].equals(numName)) {
                            System.out.printf("%s님이 맞습니다 - 변경할 번호 입력 >>", friendAry[i].split(",")[0]);
                            String number = sc.nextLine();
                            friendAry[i] = friendAry[i].split(",")[0] + "," + number + "," + friendAry[i].split(",")[2];
                            System.out.print("번호가 변경되었습니다.\n");
                            break;
                        }

                    }
                }
                break;
				

			case 6:
				System.out.println("프로그램 종료");
				run = false;
				break;
			default:
				System.out.println("다시 시작하세요.");
			}
		}

		sc.close();
	}
}
