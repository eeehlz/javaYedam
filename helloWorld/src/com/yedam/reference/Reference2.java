package com.yedam.reference;

public class Reference2 {

	public static void main(String[] args) {
		String[][] scores = { { "홍길동", "80" }, { "김민수", "85" }, { "박헌수", "88" }, { "심상현", "90" }, { "최기동", "75" }, };

		int sum = 0;
		for (int i = 0; i < scores.length; i++) {
			System.out.println("점수=>" + scores[i][1]);

			sum = sum + Integer.parseInt(scores[i][1]);
		}
		System.out.printf("평균값은 %d\n", sum);

		int max = 0;
		String name = "";

		for (int i = 0; i < scores.length; i++) {
			if (max < Integer.parseInt(scores[i][1])) {
				max = Integer.parseInt(scores[i][1]);
				name = scores[i][0];
			}
		}
		System.out.println(name);
		System.out.println(max);
	}
}
