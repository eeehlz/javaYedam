package com.yedam.api;

import java.awt.Menu;
import java.util.HashSet;
import java.util.Set;

public class HashCode {
	public static void main(String[] args) {
		// 컬렉션(List, Set, Map)
		// set : 중복된 값은 저장 불가.
		// hashCode + equels => 판단.
		Set<Member> set = new HashSet<Member>();
		set.add(new Member("user01", 100));
		set.add(new Member("user01", 100));
		set.add(new Member("user02", 110));

		for (Member mem : set) {
			System.out.println(mem.toString());
//			System.out.println(mem.memberId + ", " + mem.memPoint);
		}
	}

}