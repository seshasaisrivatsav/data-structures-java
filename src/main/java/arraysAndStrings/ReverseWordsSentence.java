/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraysAndStrings;

/**
 *
 * @author seshasai
 */
public class ReverseWordsSentence {
    public static void main(String[] args){
        String s = "this is a nice string";
        System.out.println(reversedSentence(s));
    }
    
    public static String reversedSentence(String s){
        String A = "";
        for(int i= s.length()-1; i>=0; i--){
        
            if (s.charAt(i) == ' ') {
            A= A+ s.substring(i+1, s.length())+" ";
            s = s.substring(0,i);
            }
        }
        return s;
    }
}
