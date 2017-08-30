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
public class InsertintoLinkedList extends LinkedList {
    
    public static void main(String[] args){
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(6);
        
        // add element 4 after position 3
        addElement(head, 4, 3);
        
    }
    
    public static void addElement(Node head, int element, int position){
        int counter = 0;
        Node first = head ;
        Node rest;
       //get the Linked List till position in variable "first"
        while(counter != position-1){
            first = first.next;
            counter ++;
        }
        // Store remainder of linked list in "rest" variable
        rest = first.next ;
        
        // Store the element as a node 
        Node node1 = new Node(element);
        
        // Attach the new node to the first part 
        first.next = node1;
        
        // attach the rest part to the first part
        node1.next= rest;
        
        print(head);  
        
    }
    
    public static void print(Node temp1){
        while(temp1!= null){
            System.out.println(temp1.data);
            temp1=temp1.next;
        }
    }
    
    
}
