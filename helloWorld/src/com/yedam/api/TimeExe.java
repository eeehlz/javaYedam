package com.yedam.api;

public class TimeExe {
	public static void main(String[] args) {
		// ?분 ?초 합은 ? 입니다. 출력
		// 1부터 1000000000까지 250의 배수 합을 구하는 시간

//		System.out.println(Integer.MAX_VALUE); // 2147483647
//		System.out.println(Long.MAX_VALUE); // 9223372036854775807

		long sum = 0;
		long start, end = 0;
		start = System.currentTimeMillis(); // 현재시간을 long 반환
		for (long i = 1; i <= 10000000000l; i++) {
			if (i % 20000001 == 0)
				sum += i;
		}
		end = System.currentTimeMillis();
		long jobTime = (end - start) / 1000; // 1/1000초 -> 초 환산
		long min = jobTime / 60; // 걸린시간(분)
		long sec = jobTime % 60; // 걸린시간(초)

		System.out.printf("%d분 %d초, 합: %d\n", min, sec, sum);
//			248756216094527346 ->201
//			24987508753123251 -> 2001

	}

	void test() {

	}
}
