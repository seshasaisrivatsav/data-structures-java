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
public class AddNodeatEnd extends LinkedList{
    
    public static void main(String[] args){
        int[] A = {2,2,4,5,6};
        int data = 5;
        head = listToLinkedList(A);
        printLL(addDatatoLL(head, data));
    }
    
    public static void printLL(Node head){
        while(head!=null){
            System.out.println(head.data);
            head = head.next;
        }
    }
    
    public static Node addDatatoLL(Node head, int data){
        while(head.next!=null){
            head = head.next;
        }
        head.next = new Node(data);
        
        return head;
    }
}
