package oopsConcepts;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    ///////////////////////////////////////////////////////////////////////
    //     sort the set of circles with descending order of radius       //
    ///////////////////////////////////////////////////////////////////////
    public static Integer[][] mysort(Integer[][] Set) {
        Arrays.sort(Set, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] int1, Integer[] int2) {
                Integer radius1 = int2[2];
                Integer radius2 = int1[2];
      
                return radius1.compareTo(radius2);
            }
        });
        return Set;
    }
    
    ///////////////////////////////////////////////////////////////////////
    //         Find distance between points (x1, y1) and (x2, y2)        //
    ///////////////////////////////////////////////////////////////////////
     public static double distance(double x1, double y1, double x2, double y2){
      double xdiff = x2-x1;
      double ydiff = y2-y1;
      return Math.pow ( (Math.pow(ydiff, 2))+ (Math.pow(xdiff, 2)), 0.5);
    } 
     
    ///////////////////////////////////////////////////////////////////////
    //         Returns True if Circle (x1, y1, r1) can be overlapped in  //
    //                       Circle (x2, y2, r2)                         //
    ///////////////////////////////////////////////////////////////////////
     public static boolean overlap (double x1, double y1, double r1, double x2, double y2, double r2){
         double dist = distance(x1, y1, x2, y2);
         if (dist < (r2 - r1)) {
            return true;
         }
         return false;
    }
     
    public static void main(String[] args){
        
	// Initially, the number of circles = 0
        Integer c = 0;
        
        
        // Get the number of circles from the first line of input
        Scanner n = new Scanner( System.in );
        c = n.nextInt( );
        
        
        //Initialize the set of circles 
        Integer[][] Set = new Integer[c][3];
        
        // Take the data from User
        for (int i = 0; i < c; i ++ ){ 
            Set[i][0] = n.nextInt();
            Set[i][1] = n.nextInt();
            Set[i][2] = n.nextInt();
        }
        
        //Sort the Set of circles with descending order of circles 
        Set = mysort(Set);
        
        

        //Create and intialize the altitude array
        int[] alt = new int[Set.length];
        for(int i=0; i<Set.length; i++){
            alt[i]=0;
        }
        
        //Fill up the altitude array 
        for(int i=1; i<Set.length; i++){
            for(int j=i-1; j>=0; j--){
                if((overlap(Set[i][0], Set[i][1],Set[i][2],Set[j][0],Set[j][1],Set[j][2])) == true){
                    alt[i] = Math.max(alt[i],(alt[j]+1));
                }
            }
        }
        
        
        // Find the maximum element in alt array
        int largest = alt[0];
        for(int i=1; i< alt.length; i++){
            System.out.println(alt[i]);
                if(alt[i] > largest)
                    largest = alt[i];
        }
        
        
        System.out.println(largest);
        
    }
}