package general;

import java.util.Arrays;

public class CheckAnagram {
	  
    public static void main(String[] args){
        CheckAnagram CA = new CheckAnagram();
        CA.CheckAnagram("baa", "aab");
        
    }
    
    
   public boolean CheckAnagram (String str1, String str2) {

	   if (str1.length() != str2.length())
	   return false;
	
	   char[] a = str1.toCharArray();
	   char[] b = str2.toCharArray();
	  
	   Arrays.sort(a);
	   Arrays.sort(b);
	
	   return Arrays.equals(a, b);
	   
}
    
}
