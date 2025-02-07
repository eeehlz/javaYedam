package com.yedam.collections;

import java.util.ArrayList;
import java.util.List;

public class ListExe {
	public static void main(String[] args) {
		List<String> strList = new ArrayList<String>();
		// List objList = new ArrayList();
		strList.add(null);
		strList.add("Hong");
		strList.add(new String("kildong"));
		strList.add(new String(new byte[] { 77, 108, 108, 111, 96 }));

		strList.remove(0);
		strList.size();

		strList.add(0, "Hello");
		strList.clear();

		for (int i = 0; i < strList.size(); i++) {
			System.out.println(strList.get(i));
		}
		
		System.out.println(strList.contains("Hong"));
	}
}
