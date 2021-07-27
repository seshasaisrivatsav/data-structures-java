package arraysAndStrings;

public class AmazingStrings {
	
	/*
	 * Find number of swaps needed to make a string amazing.
	 * if aa = 1
	 * aabbcc 1+1+1
	 */
	  public static void main(String[] args){
	       
         
	     String[] s = {"aabbaac", "abaaaba"};
	     
	     int[] sol = new int[s.length];
	     
	      for(int i=0; i<s.length;i++) {
	    	  	sol[i] = amazingCheck(s[i]);
	    	  	System.out.println(sol[i]);
	      }
	         
	    }
	  
	  /*
	   * Amazing string : no consecutive
	   * ababaca
	   */
	  
	  public static int amazingCheck(String s) {
		 int count=0;
		  for(int i=0; i<s.length()-1;i++) {
			  if(s.charAt(i) == s.charAt(i+1)) {
				  count++;
				  i++;
			  }
		  }
		  return count;
	  }
}
