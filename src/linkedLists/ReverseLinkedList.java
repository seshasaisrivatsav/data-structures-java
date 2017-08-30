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
public class ReverseLinkedList extends LinkedList {
    
    public static void main(String[] args){
        // Set up elements of a linked list 
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        reverseLinkedList(head);
        
    }
    
    public static void reverseLinkedList(Node head){
        Node prev = null;
        Node current = head;
        Node next = null;
        
        while(current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
       
        }
        
       printElements(prev);
        
    }
    
    public static void printElements(Node prev){
        while(prev!=null){
            System.out.println(prev.data);
            prev=prev.next;
        }
    }
        
    
     
}
