package utility;

 class ParentInheritanceJava {
	
	
	ParentInheritanceJava(){
		System.out.println("This is a parent constuctor");
	}
	
	void display() {
		System.out.println("this is parent method");
	}
}
	
	public class InheritanceJava extends ParentInheritanceJava{
		
		InheritanceJava(){
			System.out.println("This is child constructor");
		}
		
		void display() {
			
			super.display();
			System.out.println("this is child method");
		}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		InheritanceJava iher=new InheritanceJava();
		iher.display();

	}

	}
