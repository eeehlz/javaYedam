package com.yedam.inheritance;

import java.util.Scanner;
/*
 * 친구목록, 등록, 수정, 삭제.
 * 수정: 이름, 연락처 수정
 */

public class FriendExe {
	// 싱글톤
	// 1. 필드선언
	private static FriendExe instance = new FriendExe();

	// 2. 생성자 은닉
	private FriendExe() {
	}
	
	// 3. 인스턴스 반환하는 메소드
	public static FriendExe getInstance() {
		return instance;
	}

	Friend[] friends = new Friend[100];
	Scanner sc = new Scanner(System.in);

	// 시작메소드
	public void run() {
		boolean run = true;
		while (run) {

			System.out.println("== 1.친구목록 2.등록 3.수정 4.삭제 9.종료 ==");
			System.out.print(">>>");
			int menu = sc.nextInt();

			switch (menu) {
			case 1: // 목록
				friendList();
				break;

			case 2: // 등록
				addFriend();
				break;

			case 3: // 수정
				editFriend();
				break;

			case 4: // 삭제
				delFriend();
				break;

			case 9: // 종료
				System.out.println("시스템종료.");
				run = false;
			default:
				System.out.println("메뉴를 확인하세요.");
			}
		}

//		sc.close();
	}

	// 추가메소드
	void friendList() {
		System.out.println("친구목록");
		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null) {
				if (friends[i] instanceof Friend) {
					System.out.println(friends[i].showInfo());
				} else if (friends[i] instanceof UnivFriend) {

				} else if (friends[i] instanceof ComFriend) {

				}
			}
		}
	}

	// 친구: 이름, 연락처
	// 학교: 친구 + 학교명, 전공
	// 회사: 친구 + 회사명, 부서
	void addFriend() {
		while (true) {
			System.out.println("1.친구 2.학교친구 3.회사친구 4.종료");
			System.out.print(">>>");
			int choice = sc.nextInt();
			sc.nextLine();

			// 종료처리
			if (choice == 4) {
				return;
			}

			// 예외처리
			if (choice > 3 || choice < 1) {
				System.out.println("메뉴를 확인하세요.");
				continue;
			}
			// 이름,연락처
			String name = "";
			while (true) {
				System.out.print("이름입력>> ");
				name = sc.nextLine();
				if (name.length() >= 2 && name.length() <= 10) {
					break;
				} else {
					System.out.println("이름은 2글자 이상 10글자 이하...");
				}
			}
			System.out.print("번호입력>> ");
			String phone = sc.nextLine();

			Friend friend = null;
			if (choice == 1) {
				friend = new Friend(name, phone);

			} else if (choice == 2) {
				System.out.print("학교입력>> ");
				String univ = sc.nextLine();
				System.out.print("전공입력>> ");
				String major = sc.nextLine();
				friend = new UnivFriend(name, phone, univ, major);
			} else if (choice == 3) {
				System.out.print("회사입력>> ");
				String comp = sc.nextLine();
				System.out.print("부서입력>> ");
				String compMaj = sc.nextLine();
				friend = new ComFriend(name, phone, comp, compMaj);
			} else {
				System.out.println("잘못선택");
				return;
			}
			// 빈공간에 저장.
			for (int i = 0; i < friends.length; i++) {
				if (friends[i] == null) {
					friends[i] = friend;
					System.out.println("등록완료");
					break;
				}
			}
		}
	}
	
	boolean isExist;
	void editFriend() {
		System.out.println("친구수정");
		sc.nextLine();
		System.out.print("친구이름>>");
		String fr = sc.nextLine();
		System.out.print("번호입력>>");
		String phone = sc.nextLine();
		
		
		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null && friends[i].getFriendName().equals(fr)) {
				friends[i].setPhoneNumber(phone);
				isExist = true;
				break;
			}
		}
		if(!isExist) {
			System.out.println("찾는정보X");
		}
	}

	void delFriend() {
		System.out.println("친구삭제");
	}
}
