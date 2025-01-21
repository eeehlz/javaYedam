package com.yedam;

public class Variable1 {
 public static void main(String[] args) {
	 //int (4byte)
	 int num1 = 1101111;
	 short num2 = 27;
	 long num4 = 929293132132123L;
	 System.out.println(Long.MAX_VALUE);
	 
	 byte num5 = 20;
	 byte result = (byte) (num2 + num5); //강제형변환
	 int intResult = num1 + num5;
	 System.out.println("값 :::" +intResult);
	 
	 
	 // 데이터타입 변수이름 = 값
	 int[] intAry = {10,25,82,11};
	 String[] strAry = {"Hong", "Park", "choid"};
	 strAry[2] = "kim";
	 System.out.println(strAry[2]);

	 
	 int[] anotherAry = new int[10]; // 크기 10을 생성
	 for(int i = 0; i < anotherAry.length; i++) {
		 anotherAry[i] = (int) (Math.random() * 100);
	 }
	 //배열값을 출력.
	 for(int num : anotherAry) {
		 System.out.println(num);
	 }
	 System.out.println("new ary: " + anotherAry[3]);
	 
	 
	 int sum = 0;
	 for(int i = 0; i < intAry.length; i++) {
		 sum += intAry[i];
	 }
	 System.out.println("sum 의 값은 " + sum);
 }
 //commit 2025-01-21 pm 04:09dsasaasdas
}