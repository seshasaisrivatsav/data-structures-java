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
//public class Sorting{
// 
//    public static void main(String[] args){
//        // Create a stack
//       
//        Stack<Integer> s1 = new Stack<>();
//        s1.push(10);s1.push(20);s1.push(3);s1.push(11);s1.push(14);
//     
//        Stack<Integer> s2 = new Stack<>();
//        
//        // Sorting the stack 
//        //Initialize a new Stack with same size
//      
//        
//        while(!s1.isEmpty()){
//            int a = s1.pop();
//            if(s2.isEmpty()){
//                s2.push(a);
//            }
//            else{
//           
//            while(a < s2.peek()){
//                s1.push(s2.pop());
//                if(s2.isEmpty()){
//                break;
//                }
//            }
//            s2.push(a);
//            }
//        }
//        
//
//           // Print element of stack
//        while(!s2.isEmpty()){
//            System.out.println(s2.pop());
//        }
//}}
// 
