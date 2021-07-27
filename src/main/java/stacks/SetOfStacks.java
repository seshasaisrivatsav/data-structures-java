package stacks;

import java.util.ArrayList;

public class SetOfStacks {
	
	ArrayList<Stack> stacks= new ArrayList<Stack>();
	Stack currStack;
	int capacity;
	
	SetOfStacks(int capacity){
		this.capacity=capacity;
		currStack = new Stack(capacity);
		stacks.add(currStack);
	}
	
	public void push(int element) {
		if(currStack.isFull()) {
			currStack = new Stack(capacity);
			stacks.add(currStack);
		} 
		currStack.push(element);
		 
	}

	public int pop() {
		if(currStack.isEmpty()) {
			stacks.remove(stacks.size()-1);
			currStack = stacks.get(stacks.size()-1);
		}
		return currStack.pop();
		 
	}
	
	//TODO: finish roll over at popAt
//	public int popAt(int index) {
//		return currStack
//		
//	}
}
