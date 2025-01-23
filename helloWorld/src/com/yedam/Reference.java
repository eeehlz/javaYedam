package com.yedam;

public class Reference {

	public static void main(String[] args) {
		String s1 = new String("22");
		String s2 = new String("22");
		
		int d1 =  Integer.parseInt(s1);
		int d2 =  Integer.parseInt(s2);
		
		System.out.println(d1 == d2);
	}

}
