/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedLists;

import java.util.*;
/**
 *
 * @author seshasai
 */
public class PrintLinkedList extends LinkedList {
    
    
    
    public static void main(String args[]){
        // Store elements of array in a Linked List
        int A[] = {4, 1, 2, 3, 4};
        
        head = new Node (A[0]);
        Node temp1= head;
        Node temp2 = temp1;
        
        for(int i=1; i<A.length; i++){
            temp2.next = new Node(A[i]);
            temp2 = temp2.next;
        }
        
        print (temp1);
        
    }
    
    public static void print(Node temp1){
        while(temp1!= null){
            System.out.println(temp1.data);
            temp1=temp1.next;
        }
    }
}
