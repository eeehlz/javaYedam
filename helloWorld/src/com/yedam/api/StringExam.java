package com.yedam.api;

public class StringExam {
	public static void main(String[] args) {
		연습();
		no1();
		no2();
		no3();
	}

	static void 연습() {
		String str = "Hello";
		String str2 = "World";
		StringUtil.연결하기(str, str2);
	}

	static void no1() {
		String ssn1 = "88222222222222";
		String ssn2 = "991112 4583324";
		String ssn3 = "021112-3341234";
		StringUtil.checkGender(ssn3);
	}

	static void no2() {
		String file1 = "C:/temp/flower.jpg";
		String file2 = "D/web/project/guide.mp3";
		StringUtil.checkExtesion(file1);
	}

	static void no3() {
		String str1 = "  suggest";
		String str2 = " currently  ";
		String str3 = "      particular";
		StringUtil.getLength(str3);
	}
}
