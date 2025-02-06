package com.yedam.api;

public class StringUtil {

	static void 연결하기(String str, String str2) {
		// 문자열 메소드 "" + "" + ""
		System.out.println(str.concat(", ").concat(str2));
	}

	static void checkGender(String ssn) {
		// 성별 출력. 남자입니다 여자입니다
		char ch = ssn.charAt(7);
		switch (ch) {
		case '1':
		case '3':
			System.out.println("남자입니다.");
			break;

		case '2':
		case '4':
			System.out.println("여자입니다.");
			break;
		default:
			System.out.println("unknown");

		}

	}

	static void checkExtesion(String file) {
		String ext = file.substring(file.indexOf(".") + 1);
		System.out.printf("파일 확장자명은 : %s 입니다.\n", ext);
	}

	static void getLength(String str) {
		int len = str.trim().length();
		System.out.println("문자 길이는 : " + len);
	}
}