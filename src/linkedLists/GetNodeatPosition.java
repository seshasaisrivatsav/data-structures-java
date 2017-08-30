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
public class GetNodeatPosition extends LinkedList {
    
    
    public static void main(String[] args){
        
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        
        Node head1 = head;
        Node n = head;
        int tail = 0;
        
        findPos(head1,n, tail);
        
    }
    
    public static void findPos(Node head, Node n, int tail){
       
        int length = findLength(n);
        
        for(int i=0; i<(length-tail);i++){
            head = head.next;
            
        }
        
        System.out.println(head.data);
        
        
    }
    
    public static int findLength(Node head){
        int length=0;
        while(head.next!= null){
            length++;
            head = head.next;
            
        }
        return length;
    }
    
}
