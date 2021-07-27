package arraysAndStrings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Deleteme {

	  public static void main(String[] args) throws Exception{
		  
		  Set<Integer> set = new HashSet<Integer>();
		  set.add(1);
		  set.add(1);
		  set.add(1);
		  
		  System.out.println(Arrays.toString(set.toArray()));
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
