package com.yedam.interfaces.emp;

import java.util.ArrayList;
import java.util.List;

import com.yedam.inheritance.ComFriend;
import com.yedam.inheritance.Friend;

/*
 * String[] strAry;
 * Collection 1) List 2) Set 3) Map
 */
public class Exe {
	public static void main(String[] args) {
		System.out.println("홍길동".indexOf("동"));
		
		
		String[] strAry = new String[10]; // 배열
		List<String> strList = new ArrayList<String>(); // 컬랙션
		List<Friend> friends = new ArrayList<Friend>();
		
		friends.add(new Friend("홍길동","010-111"));
		friends.add(new ComFriend("김길동", "010-2222", "국민은행","신용부"));
		
		friends.remove(new Friend("홍길동","010-111"));
		System.out.println("friends크기: " + friends.size());

		// 추가
		strList.add("안녕하세요");
		strList.add("Hello");
		strList.add("반갑습니다.");
		System.out.println("strList크기: " + strList.size());

//		strList.remove(0);
//		strList.remove("Hello");
		System.out.println("strList크기: " + strList.size());

		for (int i = 0; i < strList.size(); i++) {
			System.out.println(strList.get(i));

		}
	}
}
