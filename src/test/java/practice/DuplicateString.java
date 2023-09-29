package practice;

public class DuplicateString {

	public static void main(String[] args) {
		String str = "beautiful beach";
	      char[] carray = str.toCharArray();
	      System.out.println("The string is:" + str);
	      System.out.print("Duplicate Characters in above string are: ");
	      for (int i = 1; i < str.length(); i++) {
	         for (int j = i; j < str.length(); j++) {
	            if (carray[i] == carray[j]) {
	               System.out.print(carray[j] + " ");
	               break;
	            }
	         }
	      }
	   }

}
