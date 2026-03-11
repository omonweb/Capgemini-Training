package constructors;

class A {
	public String name;
	static int age;
	
	public A(String name, int age) {
		this.name = name;
		A.age = age;
	}
	
	
	static {
		System.out.println("inside static block");
	}
	
		{
		System.out.println("inside non-static block");
	}
	
	public static void M1() {
		System.out.println("inside static public method");
	}
	public void M2() {
		System.out.println("inside public non-static method");
	}
}

public class inheritance extends A {
	
	public inheritance(String name, int age) {
		super(name, age);
	}
	public void add(int a, int b) {
		System.out.println("addition" + 
	
				(age) + 10);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		inheritance obj = new inheritance("Om", 24);
		inheritance.M1();
		obj.M2();
		obj.add(10, 20);
	}

}
