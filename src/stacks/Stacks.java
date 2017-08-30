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
public class Stacks {
    
    static long maxSize ;
    static int top;
    static int[] stackArray;
    
    static class Stack{
        Stack(int s){
            maxSize = s;
            top = -1;
            stackArray = new int[s];
        }
        
        public static void push(int a){
        top = top + 1;
        stackArray[top] = a;
        }

        public static int pop(){
           return stackArray[top--]; 
        }

        public static int peek(){
            return stackArray[top];
        }
        public static boolean isEmpty (){
            return (top == -1);
        }

        public static boolean isFull (){
             return (top == maxSize-1);
        }
    }
    
    public static void printStack(Stack S){
         while(S.isEmpty() != true){
            System.out.println(S.pop());
        }
    }
    
    // Converts a list to stack
    public static Stack listToStack(int[] list){
        Stack SStack = new Stack(list.length);
        for(int i = 0; i<list.length; i++){
            SStack.push(list[i]);
        }
        return SStack;
    }
    
    // returns the size of stack
    public static int stackSize(Stack S){
        int count = 0;
        
        if(S.isEmpty() == true){
            return 0;
        }
        
        while(S.isEmpty() != true){
            
            count++;
            S.pop();
            
        }
        return count;
    }
     
    
}
