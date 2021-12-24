package stacksAndQueues;

import java.util.Stack;

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

class MinStack {
    Stack<Integer> myStack;
    Stack<Integer> minStack;
    int currMin;
    public MinStack() {
        minStack = new Stack<>();
        myStack = new Stack<>();
    }

    public void push(int val) {
        if (!minStack.isEmpty()) {
            int peek = minStack.peek();
            minStack.push(Math.min(peek, val));
        } else {
            minStack.push(val);
        }
        myStack.push(val);
    }

    public void pop() {
        minStack.pop();
        myStack.pop();
    }

    public int top() {
        return myStack.peek();
    }

    public int getMin() {
        if (!minStack.isEmpty()) return minStack.peek();
        return -1;
    }
}

