package com.yedam.reference;

public class Book { // 필드
	private String bookName;
	private String writer;
	private String company;
	 int price;
	 
	 

	// public, default, private => 접근지시자(access modifier)
	// 생성자
	public Book(String bookName, String writer, String company, int price) {
		this.bookName = bookName;
		this.writer = writer;
		this.company = company;
		this.price = price;
	}

	// 제목, 저자, 가격
	String showBookInfo() {
		return bookName + " " + writer + " " + company + " " + price;
	}

	void showDetailInfo() {
		// 도서명 : 이것이 자바다 출판사 : 한빛미디어
		// 저자 : 신용권 가격 : 10000
		String strFormat = "도서명: %1s\t저 자: %6s\n 출판사: %3s\t\t가 격: %2d 원\n";
		System.out.printf(strFormat, bookName, writer, company, price);
	}

	public void setprice(int price) {
		if (price < 0) {
			this.price = 0;
			return;
		}
		this.price = price;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	// getter
	public String getBookName() {
		return bookName;
	}

	public String getWriter() {
		return writer;
	}

	public String getCompany() {
		return company;
	}

	public int getPrice() {
		return price;
	}

}
