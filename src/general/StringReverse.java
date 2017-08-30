package general;

public class StringReverse {
    
    public static void main(String[] args){
       String s = "abcdd";
       char[] array1 = s.toCharArray();
       int er = array1.length;
       char[] array2 = new char[er];
       for(int i=0; i<array1.length; i++){
           int a = array1.length - i -1;
           //System.out.println(array1[a]);
           array2[i] = array1[a];
        }
      String c = array2.toString();
      System.out.println(array2);
 //
    }
}
