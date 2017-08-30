/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package general;

import java.util.Scanner;

public class stringReverse1 {
    public static void main (String[] args){
       Scanner in = new Scanner(System.in);
       System.out.println("Enter a strings ");
       
        String A = in.nextLine();
       
        String reverse = "" ;
        int a = A.length() -1;
        for (int i=a; i>=0; i--){
            reverse = reverse + A.charAt(i);
        }
        System.out.println(reverse);
       
  
    }
    
}
