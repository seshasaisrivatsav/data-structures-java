package trees;

public class CheckIfGivenTreeIsBST {
	public static void main(String[] args) {

		
		/*
		 * 			NODE 1 (false)
		 			10
		 		0		25
		 	-1	   21    16  31    	
		 	
		 	
		 			NODE 2 (true)
		 			
		 			10
		 		-10		19
		 	-20   0     17
	
		 */
		Node root1 = new Node(10);
		
		 

		System.out.println(check(root1));

	}
	
	public static boolean check(Node root) {
		  return checkBSTUtil(root,Integer.MIN_VALUE, Integer.MAX_VALUE);
		
	}
	
	public static boolean checkBSTUtil(Node root, int min, int max) {
		if(root==null) return true;
		if(root.key <= min || root.key > min) return false;
		return checkBSTUtil(root.leftChild, min, root.key) && checkBSTUtil(root.rightChild, root.key, max);
		
		
		
	}

}
