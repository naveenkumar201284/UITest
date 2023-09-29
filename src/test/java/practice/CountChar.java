package practice;

public class CountChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String name="Welcome to Javatpoint portal";
		int count=0;
		for(int i=0;i<=name.length()-1;i++) {
			if(name.charAt(i)=='t') {
				count++;
				
			}
			
		}
		System.out.println(count);

	}

}
