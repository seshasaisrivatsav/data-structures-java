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
public class DeleteNode extends LinkedList{
    
        public static void main(String[] args){
            head = new Node(1);
            head.next = new Node(2);
            head.next.next = new Node(3);
            head.next.next.next = new Node(5);
            head.next.next.next.next = new Node(4);
            head.next.next.next.next.next = new Node(5);
            // delete node at position 4
            deleteNode(head, 4);
        }
        
        public static void deleteNode(Node head, int position){
            int counter = 0;
            Node first = head ;
            Node rest;
            
            while(counter < position && head.next!= null){
                first = first.next;
                counter ++;
            }
            
            rest = first.next.next ;
            
            first.next = rest;
            
            print(head);
             
             
            
            
            
        }
        
         public static void print(Node temp1){
            while(temp1!= null){
                System.out.println(temp1.data);
                temp1=temp1.next;
            }
        }
    
}
