package utility;

public class JavaExample {
	private static String beginners="naveenkumar";
	

	static class NestedExample{
		void display() {
			System.out.println(beginners);
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JavaExample.NestedExample obj=new JavaExample.NestedExample();
		obj.display();

		}
	}
}
