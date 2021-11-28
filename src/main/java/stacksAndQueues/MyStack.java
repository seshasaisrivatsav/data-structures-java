package stacksAndQueues;

import java.util.EmptyStackException;

/**
 * Stack = LIFO = Last In First Out
 * Methods
 * 	- push(item)
 * 	- pop()
 * 	- peek()
 * 	- isEmpty()
 * @param <T>
 */
public class MyStack<T> {
	private static class StackNode<T> {
		private T data;
		private StackNode<T> next;

		public StackNode(T data) {
			this.data = data;
		}
	}

	private StackNode<T> top;


	public void push(T data) {
		StackNode<T> newStackNode = new StackNode<T>(data);
		newStackNode.next = top; // V.V.I.P - Assign the next of new stack node as top, so that new is always on top
		top = newStackNode; // V.V.I.P - Now mark the new stack node as top
	}

	public T pop() {
		if (top == null) throw new EmptyStackException();
		T topItem = top.data;
		top = top.next; // move top to next
		return topItem;
	}

	public T peek() {
		if (top == null) throw new EmptyStackException();
		return top.data;
	}

	public boolean isEmpty() {
		return top == null;
	}

	public String print() {
		StringBuilder res = new StringBuilder("");
		while (top != null) {
			res.append(top.data + " =>");
			top = top.next;
		}
		return "==================================\n"  + res.substring(0, res.length()-3) +"                               || "
				+ "\n==================================\n";
	}

}
