/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package general;

import java.util.*;

/**
 *
 * @author seshasai
 */
public class UniqueCharacters {
    
    public static void main(String[] args){
 
        String s = "abcdd";
        char[] array1 = s.toCharArray();
       // int pos = 0;
                    //System.out.println(array1);
       // int prevchar = array1[pos];
       
        
        for(int i = 0; i<array1.length;i++){
            for(int j = i+1; j<array1.length;j++){
                //System.out.println(array1[i]);

                if(array1[i] == array1[j]){
                    System.out.println("false");
                    return;
                }
            }
           
        }
        
        
       /* int count = 0;
        int position = 0;
        char a = array1[position];
        for(int i=1; i<= array1.length-1; i++){
          if(array1[i] == a){
                count = count+1;
          }
          else if (count > 1) {
              
               System.out.println("false");
               break;
          }
          position =position+1;
          
            
        }*/
    }
    
   
}
