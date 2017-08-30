/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraysAndStrings;
import java.util.*;


/**
 *
 * @author seshasai
 */
public class IsUniqueString {
    
    public static void main(String[] args){
        String str = "abcd1a";
        
      //  isUnique thisObj = new isUnique();
       
       if(IsUniqueString.isUnique(str)){
            System.out.println("is unique");
       }else{
       System.out.println("is not unique");
       }
    }
    
    public static boolean isUnique(String str){
        if (str.length() > 256){
            return false;
        }
        
        boolean[] char_set = new boolean[256];
        
        for (int i=0; i < str.length(); i++){
            int val = str.charAt(i);
            if (char_set[val]){
                return false;
            }
        char_set[val] = true;
        }
        return true;
        
    }
    
}

