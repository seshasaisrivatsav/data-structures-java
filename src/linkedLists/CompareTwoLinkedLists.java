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
public class CompareTwoLinkedLists extends LinkedList {
    /* There are two linked lists. Return true only if they have same 
        Elements
    */
 
    static Node head1;
    static Node head2;
    
    public static void main(String[] args){
        int[] A = {2,2,4};
        int[] B = {2,1,4};
        head1 = listToLinkedList(A);
        head2 = listToLinkedList(B);
       
       if (compareLinkedLists(head1, head2)==true){
            System.out.println("True");
        }else{
            System.out.println("Not Matching");
       };
    }
    
 
    public static boolean compareLinkedLists(Node head1, Node head2){
        //getLinkedListLength gives me length of a linked list 
        
        if(getLinkedListLength(head1)!=getLinkedListLength(head2)){
            return false;
        }
        
        int counter = 0;
        while(head1!=null){
            if(head1.next == head2.next){
                
                counter++;
                System.out.println(counter);
            }
            
        }
        
        if(counter == getLinkedListLength(head1)){
            return true;
        }
        return false;
    }
    
     
}
