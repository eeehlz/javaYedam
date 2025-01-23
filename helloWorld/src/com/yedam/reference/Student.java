package com.yedam.reference;

public class Student {
	// 필드(속성): 이름,영어,수학.
	String studentName;
	int engScore;
	int mathScore;

	// 생성자: 필드의 초기값을 지정해서 인스턴스 생성.
	Student() { // 기본생성자 : 매개값이 없는 생성자

	}

	Student(String studentName, int engScore) {
		this.studentName = studentName;
		this.engScore = engScore;
	}
	
	Student(String studentName, int engScore, int mathScore) {
		this.studentName = studentName;
		this.engScore = engScore;
		this.mathScore = mathScore;
		
	}
	
	
	// 메소드(기능)
	void printInfo() {
		System.out.printf("이름은 %s 영어점수는 %d 수학점수는 %d\n", studentName, engScore, mathScore);
	}
	// 기능추가: 평균을 반환.
	
	double getAverage() {
		return (engScore + mathScore) / 2.0;
	}

}
