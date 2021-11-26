package stacks;

/// Implements queue using two stacks
public class MyQueue {
	Stack<Number> sNew, sOld;
	
	/*
	 * Add
	 * Remove
	 * Peek
	 * TODO: isEmpty
	 * TODO: isFull
	 */
	
	public void add(int element) {
		sNew.push(element);
	}
	
	public int remove() {
		shuffleStacks();
		return sOld.pop();
	}
	
	public int peek() {
		shuffleStacks();
		return sOld.peek();
	}
	
	
	
	
	
	public void shuffleStacks() {
		if(sOld.isEmpty()) {
			while(!sNew.isEmpty()) {
				sOld.push(sNew.pop());
			}
		}
	}
	

}
