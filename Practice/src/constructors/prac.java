package constructors;

import java.util.Scanner;

class caller {
	String name;
	int age;
	String lastName;
	
	private caller() {	
		this("");
		System.out.println("first constructor");	
	}
	
	private caller(String name) {
		this(name,0);
		System.out.println("second constructor");
	}
	
	private caller(String name,int age) {
		this.name = name;
		this.age = age;
		
		System.out.println("third constructor");
	}
	public static caller func(String name, int age) {
		
		return new caller(name,age);
	}
	
	public void printName() {
		System.out.print(name);
	}
}
	public class prac {

	public static void main(String[] args) {
		
		caller obj = caller.func("om", 23);
		obj.printName();
		
	}

}
