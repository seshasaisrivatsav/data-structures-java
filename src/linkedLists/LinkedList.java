/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedLists;

/**
 *
 * @author seshasai
 */
public class LinkedList {
    Node head;  // head of list
 
    /* Linked list Node.  This inner class is made static so that
       main() can access it */
    public static class Node {
        int data;
        Node next;
        // Constructor
        Node(int d) {
            data = d;  
            next=null; 
        } 
    }
    
    public  int getLinkedListLength(Node head){
        int count = 0;
        while(head!=null){
            count++;
            head = head.next;
        }
        return count;
    }
    
 
    public Node listToLinkedList(int[] A){
        Node h = new Node (A[0]);
        Node temp1= h;
        Node temp2 = temp1;
        
        for(int i=1; i<A.length; i++){
            temp2.next = new Node(A[i]);
            temp2 = temp2.next;
        }  
        
        return temp1;
    }
    
    public static void main(String[] args){
        Node head = new Node(10);
        head.next = new Node(6);
        head.next.next = new Node(7);
        
        
        
     
      
     }
     
}
