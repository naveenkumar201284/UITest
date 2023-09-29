package practice;

public class Polyndrom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name="MalayalaM";
		String rev="";
		int length=name.length();
		for(int i=length-1;i>=0;i--) 
		{
			rev=rev+name.charAt(i);
		}
		System.out.println(rev);
		if(name.equals(rev)) 
			System.out.println("This is a polyndrom");
		else
			System.out.println("This is not a polyndrom");

	}

}
