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
public class ReverseLinkedListItertion extends LinkedList {
    
    public static void main(String[] args){
        head = new Node(5);
        head.next = new Node(6);
        head.next.next= new Node(7);
        head.next.next.next = new Node(8);
        head.next.next.next.next = new Node(9);
        
        printReverse (head);
    }
    
    public static void printReverse(Node head){
        if(head!=null){
            printReverse(head.next);
            System.out.println(head.data);
        }
    }
    
}
