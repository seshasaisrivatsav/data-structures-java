package stacks;


// Also returns min in O[1]
public class Stack<I extends Number> {
	
	public int top;
	public int size;
	//first[0]=value , second [1] = minimum element 
	public int[][] stack;
	
	
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
		stack = new int[size][2];
	}
	
	public void push(int element) {
		if (this.isEmpty()) {
			top = top + 1;
			stack[top][0] = element;
			stack[top][1] = element;
		} else {
			if(element < stack[top][1]) {
				top = top + 1;
				stack[top][0] = element;
				stack[top][1] = element;
			}else {
				top = top + 1;
				stack[top][0] = element;
				stack[top][1] = stack[top - 1][1];
			}
			
		}
	}
	
	public int pop() {
		return stack[top--][0];
	}
	
	public int peek() {
		return stack[top][0];
	}

	public int min() {
		return stack[top][1];
	}
	public boolean isEmpty() {
		return top==-1? true:false;
	}
	 
	
	public boolean isFull() {
		return top==size-1;
	}
	
	
	
	

}
