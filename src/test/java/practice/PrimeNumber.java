package practice;

public class PrimeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count=12,temp=0;
		
		for(int i=2;i<=count-1;i++) 
			{
			
			if(count%i==0) {
				temp++;
			}
		}
		
		if(temp==0) 
			System.out.println("This is a prime number");
			
			else
				System.out.println("This is not a prime number");
		

	}
}
