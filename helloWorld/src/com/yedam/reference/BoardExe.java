package com.yedam.reference;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
//import java.util.Iterator;
import java.util.Scanner;

/*
 * 실행클래스.
 * 1.글목록 2.글등록 3.삭제 9.종료
 */

public class BoardExe {
	static Board[] boardRepo = new Board[100]; // 게시글등록 배열
	static Scanner sc = new Scanner(System.in);
	static String LoginId;

	public static void initData() throws ParseException {
		// 배열의 샘플 데이터
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		boardRepo[0] = new Board("게시글제목1", "내용입니다1", "user01", sdf.parse("2025-01-27"));
		boardRepo[1] = new Board("게시글제목2", "내용입니다2", "user02", sdf.parse("2025-01-28"));
		boardRepo[2] = new Board("게시글제목3", "내용입니다3", "user03", sdf.parse("2025-01-29"));
		boardRepo[3] = new Board("게시글제목4", "내용입니다4", "user04", sdf.parse("2025-01-30"));
		boardRepo[4] = new Board("게시글제목5", "내용입니다5", "user05", sdf.parse("2025-01-27"));

		boardRepo[5] = new Board("게시글제목5", "내용입니다5", "user05", sdf.parse("2025-01-28"));
		boardRepo[6] = new Board("게시글제목6", "내용입니다6", "user06", sdf.parse("2025-01-29"));
		boardRepo[7] = new Board("게시글제목7", "내용입니다7", "user07", sdf.parse("2025-01-30"));
		boardRepo[8] = new Board("게시글제목8", "내용입니다8", "user08", sdf.parse("2025-01-30"));
		boardRepo[9] = new Board("게시글제목9", "내용입니다9", "user09", sdf.parse("2025-01-30"));

		boardRepo[10] = new Board("게시글제목10", "내용입니다10", "user10", sdf.parse("2025-01-30"));
		boardRepo[11] = new Board("게시글제목11", "내용입니다11", "user11", sdf.parse("2025-01-30"));
		boardRepo[12] = new Board("게시글제목12", "내용입니다12", "user12", sdf.parse("2025-01-30"));
		boardRepo[13] = new Board("게시글제목13", "내용입니다13", "user13", sdf.parse("2025-01-30"));
		boardRepo[14] = new Board("게시글제목14", "내용입니다14", "user14", sdf.parse("2025-01-30"));
//		boardRepo[15].setTitle("test");
	}

	public static void boardList() {
		// 글목록.
		// 1페이지: 0~4, 2페이지: 5~9, 3페이지: 10~14
		int page = 1;
		int lastPage = (int) Math.ceil(getMaxCount() / 5.0); // 13/5 => 2.6 ceil 반올림?

		while (true) {

//			int firstIdx = (page - 1) * 5;
//			int lastIdx = (page * 5) - 1;
//			for (int i = firstIdx; i <= lastIdx; i++) {
//				if (boardRepo[i] != null) {
//					System.out.println(boardRepo[i].showBoard());
//				}//			}

			int endCnt = page * 5;
			int startCnt = endCnt - 5;
			int loopCnt = 0;
			System.out.println("------------------------------------");
			for (int i = 0; i < boardRepo.length; i++) {
				if (boardRepo[i] != null) {
					loopCnt++;
					if (loopCnt > startCnt && loopCnt <= endCnt) {
						System.out.println(loopCnt + "" + boardRepo[i].showBoard());
					}
				}
			} // end of for

			System.out.println("이전페이지: p, 다음페이지: n, 종료: q");
			String paging = sc.nextLine();
			if (paging.equals("n")) {
				// 마지막페이지보다는 작은값.
				if (page < lastPage) {
					page++;
				}
			} else if (paging.equals("p")) {
				// 1보다는 큰 페이지.
				if (page > 1) {
					page--;
				}
			} else if (paging.equals("q")) {
				return;
			} else {
				System.out.println("잘못된 메뉴를 선택함.");

			}
		}
	} // end of boardList()
		// 배열을 매개값으로 전달하면 건수가 몇건 반환 메소드

	public static int getMaxCount() {
		int count = 0; // 전체건수
		for (int i = 0; i < boardRepo.length; i++) {
			if (boardRepo[i] != null) {
				count++;
			}
		}
		return count++; // 건수반환
	}

	public static void addBoard() {
		// 글등록.
		// 제목: 5글자 이상 ~ 15글자 이하. 어길시 콘솔출력("등록X")
		// 똑같은 글제목이 있으면 콘솔출력("이미 있는 제목입니다.")
		
		System.out.print("제목을 입력하세요 >>");
		String title = sc.nextLine();
		System.out.print("내용을 입력하세요 >>");
		String content = sc.nextLine();
//		System.out.print("작성자를 입력하세요 >>");
//		String writer = sc.nextLine();
//		System.out.print("작성일시를 입력하세요 >>");
//		String writeDate = sc.nextLine();
		// 배열의 빈공간에 등록.
	
		for (int i = 0; i < boardRepo.length; i++) {
			if (boardRepo[i] == null) {
				if(title.length() > 5 || title.length() < 15) {
					boardRepo[i] = new Board(title, content, LoginId, new Date());
					System.out.println("등록이 완료되었습니다.");
					break;
				}else {
					System.out.println("등록 불가합니다.");
					break;
				}
//				break; // 한건만 등록. 후 break;
			}
		}
	}

	public static void removeBoard() {
		// 글삭제. 제목을 찾아서 삭제
		System.out.print("글제목을 입력하세요 >>");
		String del = sc.nextLine();
		for (int i = 0; i < boardRepo.length; i++) {
			if (boardRepo[i].getTitle() != null && boardRepo[i].getTitle().equals(del)) {
				boardRepo[i] = null;
				System.out.println("글삭제 완료");
				break;

			}
		}

	}

	public static void main(String[] args) {
		// id, password 일치하면 글목록 사용가능.
		// 불일치시 반복
//		MemberExe exe = new MemberExe(); // 인스턴스.
		

		while (true) {

			System.out.print("아이디 입력:");
			String id = sc.nextLine();
			System.out.print("비밀번호 입력:");
			String pw = sc.nextLine();

			String name = MemberExe.login(id, pw);
			
			if (name != null) {
				LoginId = id; // 여러메소드 공용사용.
				System.out.println(name + "님 ===환영합니다!===");
				break;
			} else {
				System.out.println("아이디와 비밀번호 확인하세요.");
			}
		} // end of while.

		boolean run = true;
		try {
			initData();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		while (run) {
			System.out.println("     1.글목록  2.글등록  3.삭제  9.종료");
			System.out.print(">> ");
			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1: // 목록
				boardList();
				break;
			case 2: // 등록
				addBoard();
				break;
			case 3: // 삭제
				removeBoard();
				break;
			case 9: // 종료
				System.out.println("프로그램 종료");
				run = false;
				break;
			default: // 1,2,3,9 외의 경우.
				System.out.println("메뉴를 확인하세요.");
			}// end of switch

		} // end of while
		System.out.println("end of prog.");
		sc.close();
	} // end of main

}