/*
 * 도서명, 저자, (조회)출판사, 판매가격
 */
package com.yedam.reference;

import java.util.Scanner;

public class BookExe {
	public static void init() {
		// 초기 데이터
		bookRepository[0] = new Book("책1", "저자1", "회사1", 30000);
		bookRepository[1] = new Book("책2", "저자2", "회사2", 20000);
		bookRepository[2] = new Book("책3", "저자3", "회사3", 27000);
		bookRepository[3] = new Book("책4", "저자4", "회사4", 10000);

	}

	// case 1
	public static void printList() {
		System.out.println("전체목록 출력");
		System.out.println("도서명    저자    춢판사   가격");
		System.out.println("------------------------------");
		for (int i = 0; i < bookRepository.length; i++) {
			if (bookRepository[i] != null) {
				System.out.println(bookRepository[i].showBookInfo());
			}
		}
		System.out.println("------------------------------");
	} // case 1 end

	// case 2
	public static void addBook() {
		System.out.print("도서명을 입력>");
		String name = sc.nextLine();
		System.out.print("저자 입력>");
		String auther = sc.nextLine();
		System.out.print("출판사를 입력>");
		String company = sc.nextLine();
		System.out.print("가격을 입력>");
		int price = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < bookRepository.length; i++) {
			if (bookRepository[i] == null) {
				bookRepository[i] = new Book(name, auther, company, price);
				System.out.println("등록완료");
				break;
			}

		}
	} // case 2 end

	// case 3
	public static void searchList() {
		System.out.print("출판사 조회 >");
		String press = sc.nextLine();
		boolean end = false;
		for (int i = 0; i < bookRepository.length; i++) {
			if (bookRepository[i] != null && bookRepository[i].getCompany().equals(press)) {
				System.out.println(bookRepository[i].showBookInfo());
			}

		}
		if (!end) {
			System.out.println("찾는 도서 없음");
		}
	} // case 3 end

	// case 4
	public static void modifyBook() {
		System.out.print("수정할 도서명:");
		String newName = sc.nextLine();
		System.out.print("수정할 가격:");
		int newPrice = Integer.parseInt(sc.nextLine());
		boolean isExist = false;

		for (int i = 0; i < bookRepository.length; i++) {
			if (bookRepository[i] != null && bookRepository[i].getBookName().equals(newName)) {
				bookRepository[i].price = newPrice;
				System.out.println("수정완료");
				isExist = true;
				break;
			}
		}
		if (!isExist) {
			System.out.println("찾는 도서 없음");
		}
	} // case 4 end
	
	//case 5 
	public static void showDetail() {
		System.out.print("도서명 입력>> ");
		name = sc.nextLine();
		Calculator cal = new Calculator();
		cal.getBookInfo(name, bookRepository).showDetailInfo();
//		for (int i = 0; i < bookRepository.length; i++) {
//			if (bookRepository[i] != null && bookRepository[i].getBookName().equals(name)) {
//				bookRepository[i].showDetailInfo();
//				break;
//			}
//		}

	} //case 5 end
	
	
	static String name;
	static Scanner sc = new Scanner(System.in);
	static Book[] bookRepository = new Book[100];

	public static void main(String[] args) {
		init();
		boolean run = true;

		// 1.전체목록 2.도서등록 3.조회(출판사) 9.종료

		while (run) {
			System.out.println("1.전체목록 2.도서등록 3.조회(출판사) 4.수정 5.상세조회 9.종료");
			System.out.print("메뉴를 입력하시오 >>");
			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {

			case 1:
				printList();
				break;
			// case 1 end

			case 2:
				addBook();
				break;
			// case 2 end

			case 3:
				searchList();
				break;
			// case 3 end

			case 4:
				modifyBook();
				break;

			case 5: // 상세조회
				showDetail();
				break;

			case 9:
				System.out.println("end program");
				run = false;
				break;
			default:
				System.out.println("다시 시작하세요.");
				// case 9 end
			}

		}
		sc.close();
	} // end of main
}
