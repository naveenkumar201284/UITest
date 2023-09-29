package practice;

public class StarPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int numb=4;
		for(int i=1;i<=numb;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
	}

}
