package utility;

interface A{
	public void display();
	public void display1();
	}

interface B extends A{
	public void display2();
	}

public class DemoInterface implements B{

	public static void main(String[] args) {
		DemoInterface  di=new DemoInterface();
		di.display();
		di.display1();
		di.display2();
	}

	public void display() {
		System.out.println("This is display method");
	}

	public void display1() {
		System.out.println("This is display1 method");
	}

	public void display2() {
		System.out.println("This is display2 method");
	}

}
