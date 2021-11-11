package linkedLists;

public class findMidinLinkedList{
	public static void main(String []args) {
		Node head1 = new Node(1);
	    head1.next = new Node(2);
	    head1.next.next = new Node(3);
	    head1.next.next.next = new Node(4);
	    head1.next.next.next.next = new Node(5);
	    head1.next.next.next.next.next = new Node(6);
	    //head1.next.next.next.next.next.next = new Node(7);
	    
	    findMid(head1);
	       
   }
   
   public static void findMid(Node head){
	   Node s, f;
	   f= s = head;
	   while(s!=null && f!=null){
		   if(f.next==null || f.next.next==null){
			   //System.out.print(s.data);
			   break;
		   }
		   
			   s=s.next;
			   f=f.next.next;
	}
	   System.out.println(s.data);
	   
   }
   
   


static class Node{
     Node next;
     int data;
    
    Node(int d){
        data = d;
        next = null;
    }
    
}
}
