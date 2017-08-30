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
public class PushElementsStack extends Stacks{
    
    public static void main(String[] args){
        Stack s1 = new Stack(10);
        
        //Insert elements into stack
        for(int i=1; i<=10; i++){
            s1.push(i);
        }
        
        //print elements of stack
       printStack(s1);
    }
    
    
}
