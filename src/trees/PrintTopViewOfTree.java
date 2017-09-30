package trees;
 

public class PrintTopViewOfTree {
	public static void main(String[] args) {
		   

		   	Node root = new Node(5);
		   	root.leftChild = new Node(10);
		   	root.rightChild = new Node(15);
		   	root.leftChild.leftChild = new Node(20);
		   	root.leftChild.rightChild = new Node(25);
		   	root.rightChild.leftChild = new Node(30);
		   	root.rightChild.rightChild = new Node(35);		
		   	root.rightChild.leftChild.leftChild = new Node(31);
		   	root.rightChild.rightChild.rightChild = new Node(39);
		   	
           
			/*				   5
			 * 			10	      	15
			 * 		20	   25	 30     35
			 * 					31		  39
			 * 
			 * O/P = 20 10 5 15 35 39
			 */
		   	printLeft(root.leftChild);
		   	printRight(root);
		   	
	}

	/*
	 * To print the left side
	 */
	public static void printLeft(Node root) {
		if(root !=null){
			printLeft(root.leftChild);
            System.out.println(root.key);
       
    }

	}
	
	/*
	 * Print right side with root
	 */
	public static void printRight(Node root) {
		if(root!=null) {
			System.out.println(root.key);
			printRight(root.rightChild);
		}
	
	}
	
	
}
