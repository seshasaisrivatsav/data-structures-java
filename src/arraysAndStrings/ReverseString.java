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
public class ReverseString {
    
    public static void main(String[] args){
        String str = "abraca ";
        
        System.out.println(stringReverse(str));
    }
     
    public static String stringReverse(String str){
        String answer="";
        int length = str.length()-1;
        for(int i = 0 ; i < str.length(); i++){
            //answer <- answer + str(length-1-i)
            //answer.append(str.charAt(str.length()-i-1).toString);
            answer = answer + str.charAt(str.length()-1-i);
        }
        if(str.charAt(length) == ' '){
                 return answer = answer.substring(1);
            }else {
                return answer;
            }
    }
    
}
