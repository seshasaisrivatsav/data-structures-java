package stacks;

public class Stack {
	
	public int top;
	public int size;
	public int[] stackArray;
	
	/* Stack Methods
	 1. peek  -> Return top value of stack
	 2. push  -> Insert 
	 3. pop   -> Remove top element of stack latest
	 4. isEmpty  Return true if array isEmpty
	 5. isFull-> Return true if array size is top
	 */
	
	Stack(int size){
		this.size = size;
		top = -1;
		stackArray = new int[size];
		
	}
	
	public int peek(Stack s) {
		int x = stackArray.length - 1;
		return stackArray[x];
	}
	
	
	
	

}
