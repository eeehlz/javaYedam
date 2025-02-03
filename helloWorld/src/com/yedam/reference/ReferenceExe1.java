package com.yedam.reference;

public class ReferenceExe1 {

	public static void main(String[] args) {
		// static : 정적 메소드 , void : (반환되는 값 X)표현

		// 배열선언.
		double[] dblAry = new double[5];
		dblAry[0] = 171.3;
		System.out.println(dblAry.length); // 5
		for (int i = 0; i < dblAry.length; i++) {
			System.out.printf("%scm, ", dblAry[i]);
		}
		System.out.println();

		dblAry = new double[] { 160.5, 174.6 }; // 값을 넣는게 아니라 새로 배열선언
		System.out.println(dblAry.length); // 2

		// 배열[][] => 다차원배열.
		int[][] intAry = new int[2][3];
		intAry[0][0] = 10;
		intAry[0][1] = 20;
		intAry[0][2] = 30;
		intAry[1][0] = 20;
		intAry[1][1] = 30;
		intAry[1][2] = 40;

		for (int j = 0; j < intAry[0].length; j++) {
			for (int i = 0; i < intAry[0].length; i++) {
				System.out.println("[" + j + "]" + "[" + i + "]" + "=>" + intAry[j][i]);
			}
		}

	}

	public int sum(int num1, int num2) {
		return num1 + num2;
	}

	public void method1() {
		System.out.println("method1()이 호출되었습니다.");
	}

//	private void method2() {
//		System.out.println("method2()이(가) 호출되었습니다.");
//	}

}
