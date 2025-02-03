package com.yedam.reference;

public class StaticExe {
	public static void main(String[] args) {
		MemberExe m1 = MemberExe.getInstance();
		MemberExe m2 = MemberExe.getInstance();
		
		System.out.println(m1 == m2);
	}
}
