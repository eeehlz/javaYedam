package com.yedam.collections;

class Box<E> {
	E item;

	void setItem(E item) {
		this.item = item;
	}

	Object getItem() {
		return item;
	}
}

public class BoxExe {
	public static void main(String[] args) {
		Box<Integer> box = new Box<Integer>();
//		box.setItem("오렌지");
		box.setItem(100);

		Object result = (Integer) box.getItem(); // Object -> String
		System.out.println(result);
	}
}
