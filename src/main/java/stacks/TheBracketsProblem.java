///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package stacks;
//import java.util.*;
///**
// *
// * @author seshasai
// */
//public class TheBracketsProblem {
//    
//    public static void main(String[] args){
//        String S = "{(())}]";
//        
//        Stack<Character> s1 = new Stack<>();
//     
//        for(int i = 0; i< S.length(); i++){
//            if(S.charAt(i)== ('{' | '(' | '[' )){
//                s1.push(S.charAt(i));
//            }else if(!s1.isEmpty() || S.charAt(i) == ('}' | ')' | ']')){
//                    char a = S.charAt(i);
//                    if(a==')' && s1.peek()=='('){
//                        s1.pop();
//                    }
//                    else if(a=='}' && s1.peek()=='{'){
//                        s1.pop();
//                    }
//                    else if(a==']' && s1.peek()=='['){
//                        s1.pop();
//                    }
//                }
//            else{
//                
//                if(S.charAt(i) == ']' || S.charAt(i) == ')'){
//                   
//                    s1.push(S.charAt(i));
//                }
//            }
//            
//        }
//        
//        if(s1.isEmpty()){
//            System.out.println("Good");
//        }else{
//            System.out.println("Bad");
//        }
//        
//    }
//}
