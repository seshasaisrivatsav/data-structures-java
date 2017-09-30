package arraysAndStrings; 


public class Deleteme {

	  public static void main(String[] args) throws Exception{
		  try {
			  int i = Integer.parseInt("abcd");
		  }
		  
		  catch(NumberFormatException ex) {
			  System.out.println("Number format exception");
		  }
		  

		  catch(Exception ex) {
			  System.out.println("your code broke");
		  }
		  
	  }
}
