/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stacks;

/**
 *
 * @author seshasai
 */
public class FindMax extends Stacks {
    
    public static void main(String[] args){
        int[] A  = {8, 5 , 4, 35, 14};
        Stack s1 = listToStack(A);
        
        int  a = s1.pop();
       
        while(!s1.isEmpty()){
    
            if(a < s1.peek()){
                a = s1.pop();   
            }else{
                s1.pop();
            }
        }
        
        System.out.println(a);
    }
    
}
