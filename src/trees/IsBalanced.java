package trees;



public class IsBalanced {

	public static void main(String[] args) {
		
		Node root = new Node(5);
		root.leftChild = new Node(10);
		root.rightChild = new Node(15);
		root.leftChild.leftChild = new Node(20);
		root.leftChild.rightChild = new Node(25);
		root.rightChild.leftChild = new Node(30);
		root.rightChild.rightChild = new Node(35);		
	
		root.rightChild.rightChild.rightChild = new Node (40);
		root.rightChild.rightChild.rightChild.rightChild = new Node (45);
		
		System.out.println(isBalanced(root));
		
		
	}
	
	public static boolean isBalanced(Node root) {
		System.out.println("Height "+ Height(root));
		System.out.println("minHeight "+ minHeight(root));
		if((Height(root)-minHeight(root))<=1) {
			return true;
		}else {
			return false;
		}
	}
	
	
	public static int Height(Node root) {
		int maxLeft, maxRight;
		if(root ==null) {
			return -1;
		}else {
			maxLeft = Height(root.leftChild);
			maxRight = Height (root.rightChild);
			return 1+Math.max(maxLeft, maxRight);
		}
	}
	
	public static int minHeight(Node root) {
		if(root==null) {
			return -1;
		}
		if(root.leftChild ==null && root.rightChild==null) {
			return 0;
		}
		if(root.leftChild ==null) {
			return minHeight(root.rightChild)+1;
		}
		if(root.rightChild==null) {
			return minHeight (root.leftChild)+1;
		}
		
		return 1+Math.min(minHeight(root.leftChild), minHeight(root.rightChild));
	}
}
