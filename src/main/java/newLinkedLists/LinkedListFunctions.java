package newLinkedLists;

public class LinkedListFunctions {
	
	public int length(Node a) {
		int count=0;
		while(a!=null) {
			count++;
			a = a.next;
		}
		return count;
	}
	
	
	

}
