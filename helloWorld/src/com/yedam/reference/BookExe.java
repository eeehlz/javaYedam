package com.yedam.reference;

import java.util.Scanner;

/*
 * 도서명, 저자, (조회)출판사, 판매가격
 */
public class BookExe {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Book[] bookRepository = new Book[100];
		
		Book std1 = new Book();
		std1.bookName = "책1";
		std1.writer = "김길동";
		std1.company = "회사1";
		std1.price = 1000;
		
		Book std2 = new Book();
		std2.bookName = "책2";
		std2.writer = "홍길동";
		std2.company = "회사2";
		std2.price = 2000;
		
		boolean run = true;
		// 1.전체목록 2.도서등록 3.조회(출판사) 9.종료

		while (run) {
			System.out.println("1.전체목록 2.도서등록 3.조회(출판사) 9.종료");
			System.out.print("메뉴를 입력하시오 >>");
			int menu = sc.nextInt();
			switch (menu) {
			case 1:
				System.out.println("전체목록 출력");
				for (int i = 0; i < bookRepository.length; i++) {
					if (bookRepository != null) {
						System.out.println();
						break;
					}
				}
				break;
			case 2:

			case 3:

			case 9:
				System.out.println("end program");
				run = false;
				break;
			default:
				System.out.println("다시 시작하세요.");
			}

		}

	} // end of main
}
