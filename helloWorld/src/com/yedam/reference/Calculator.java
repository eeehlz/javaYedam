package com.yedam.reference;

//import java.util.Iterator;

public class Calculator {
	// 1월달 출력.
	public void showCalendar() {
		int spaces = 6;
		int lastDate = 31;
		String[] dateAry = new String[30];
		// 배열에 값 채우기
		for (int i = 0; i < dateAry.length; i++) {
			if (i < spaces) {
				dateAry[i] = "";
			} else {
				dateAry[i] = "" + (i + 1 - spaces);
			}
		}

		String[] days = { "Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat" };
		for (String day : days) {
			System.out.printf("%4s", day);
		}
		System.out.println("\n---------------------------------------------");

//		 for (int i = 0; i < dateAry.length; i++) {
//			
//		}
	}

	public Book getBookInfo(String btilte, Book[] bookAry) {
//		Book[] bookRepo = {new Book("이것이 자바다","신용권","한빛미디어",10000)
//		,new Book("자바스크립트기초","김자바","자바출판사",15000)
//		,new Book("혼자공부하는자바","혼공자","한빛미디어",20000)
//		};

		for (int i = 0; i < bookAry.length; i++) {
			if (bookAry[i].getBookName().equals(btilte)) {
				return bookAry[i];
			}
		}
		return null;
	}

	// 1~100 사이의 임의값을 n개 반환
	public int[] randomAry(int n) {
		int[] result = new int[n];
		for (int i = 0; i < result.length; i++) {
			result[i] = (int) (Math.random() * 100) + 1;
		}
		return result;
	}

	// 두 숫자중에서 큰값을 반환(return)해주는 메소드
	public int getMax(int num1, int num2) {
		return num1 > num2 ? num1 : num2;
//		if (num1 > num2) {
//			return num1;
//		} else {
//			return num2;
//		}
	}

	// 별 출력하는 메소드
	public void printStar(int items) { // 매개변수
		for (int i = 0; i <= items; i++) {
			printStar(i, "*");
			System.out.println();
		}
	}

//	System.out.println("*");
//	System.out.println("**");
//	System.out.println("***");
//	System.out.println("****");

	public void printStar(int times, String types) {
		for (int i = 0; i <= times; i++) {
			System.out.print(types);
		}
	}

	public int sum(int num1, int num2) {
		return num1 + num2;
	}

	public double sum(double num1, double num2) {
		return num1 + num2;
	}

	public int sum(int[] intAry) {
		int sum = 0;
		for (int i = 0; i < intAry.length; i++) {
			sum += intAry[i];
		}
		return sum;
	}

}
