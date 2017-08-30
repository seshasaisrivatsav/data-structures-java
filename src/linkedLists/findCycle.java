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


public class findCycle {

	public static void main(String[] args){
		
	    Node head1 = new Node(1);
	    head1.next = new Node(2);
	    head1.next.next = new Node(3);
	    head1.next.next.next = new Node(4);
	    head1.next.next.next.next = new Node(5);
	   // head1.next.next.next.next.next = head1.next.next.next;
	  
	    

	    
	    detectCycle(head1);
	}
	
	public static void detectCycle(Node head1){
		Node s, f;
		s=head1;
		f=head1;
		
                if(s == s.next){
                    System.out.println("There is a cycle");
                    return;
                }
                
		while(s!=null && f.next!=null)
		{
			s=s.next;
			f=f.next.next;
			
			if(s==null || f == null){
				System.out.println("no cycles");
				return;
			}
		
			if(s==f){
				System.out.println("There is a cycle");
				return;
			}
		 
		
			
		}
		System.out.println("No Cycles");
	}
	
}

