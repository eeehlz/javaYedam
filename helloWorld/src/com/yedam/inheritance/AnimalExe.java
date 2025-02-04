package com.yedam.inheritance;

public class AnimalExe {
	public static void main(String[] args) {
		Animal animal = null;

		animal = new Dog();
		animal.sound();

		animal = new Cat();
		animal.sound();
	}
}
