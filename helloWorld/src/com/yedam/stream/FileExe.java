package com.yedam.stream;

//import java.util.Iterator;
//import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class FileExe {
	public static void main(String[] args) {
		try {
			Reader reader = new FileReader("C:/temp/ListExe.java");
			while (true) {
				int chr = reader.read(); // char(2byte)
				System.out.print((char) chr); // 65 -> A
				if (chr == -1)
					break;

			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("end of prog");
	}// end of main

	// 문자기반 테스트 생성
	void write() {
		// 문자기반 파일출력
		try {
			Writer wr = new FileWriter("C:/temp/test3.txt");
			wr.write(65);
			wr.write(new char[] { 'B', 'C' });
			wr.write("DEF");

			wr.flush();
			wr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 파일복사
	void copy() {
		// C:/temp/sample.png -> C:/temp/copy.png 생성.
		try {
			InputStream is = new FileInputStream("C:/temp/sample.png");
			OutputStream os = new FileOutputStream("C:/temp/copy2.png");

			int data = -1;
			byte[] buf = new byte[100];
			while (true) {
				// 읽기
				data = is.read(buf); // 더 이상 읽을 바이트가 없으면 -1 반환.
				os.write(data); // 출력(바이트 쓰기)
				if (data == -1)
					break;
			}
			is.close();
			os.flush();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 바이트 기반 파일 읽기
	void input() {
		try {
			InputStream is = new FileInputStream("C:/temp/test1.dat");
			while (true) {
				int data = is.read(); // 바이트 읽고 반환. -1값 반환.
				System.out.println(data);
				if (data == -1)
					break;
			}
			is.close();

		} catch (IOException e) {
			e.printStackTrace();																
		}
	}

	void output() {
		// 출력스트림(바이트기반) OutputStream
		try {
			OutputStream os = new FileOutputStream("C:/temp/test1.dat");
			os.write(10);
			os.write(20);
			os.write(30); // 쓰기.
			os.flush(); // 버퍼비우기.
			os.close();// 리소스 활용 후 반환.

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
