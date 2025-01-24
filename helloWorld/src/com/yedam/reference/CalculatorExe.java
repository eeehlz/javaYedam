package com.yedam.reference;

public class CalculatorExe {
	public static void main(String[] args) {

//		Calculator cal = new Calculator();
//		cal.printStar(3);
		
		Book[] bookStore = {new Book("이것이 자바다","신용권","한빛미디어",10000)
				,new Book("자바스크립트기초","김자바","자바출판사",15000)
				,new Book("혼자공부하는집에","혼공보","한빛미디어",20000)
				,new Book("혼자공부하는가고","혼공하","한빛미디어",20000)
				,new Book("혼자공부하는싶다","혼공가","한빛미디어",20000)
				};
		
		
		Calculator showCalculator = new Calculator(); // 메서드 호출
		Calculator cal = new Calculator();
		
		Book author = cal.getBookInfo("혼자공부하는가고", bookStore);
		if(author != null) {
			author.showDetailInfo();
		} else {
			System.out.println("없음");
		}
		
		int[]randomA = cal.randomAry(5);
		for(int num : randomA) {
			System.out.println("숫자" + num);
		}
		System.out.println(cal.sum(randomA));
		
		int[] ary1 = { 14, 32, 52, 55, 86 };
		int[] ary2 = { 34, 92, 32, 15, 65 };
		int max = cal.getMax(cal.sum(ary1), cal.sum(ary2));
		System.out.printf("배열의 합이 큰값은 %d ", max);

		double n1 = 10.5;
		double n2 = 20.5;
		double result = cal.sum(n1, n2);

		result = cal.sum(new int[] { 10, 20, 30, 40 });
		System.out.println("결과:" + result);

	}
}
