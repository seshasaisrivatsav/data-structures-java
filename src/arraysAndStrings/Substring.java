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
public class Substring {
    
    public static void main(String[] args){
        String S = "thisistheplace";
        System.out.println(subs(S));
    }
    
    public static String subs(String S){
        return S.substring(2,5);
    }
}
