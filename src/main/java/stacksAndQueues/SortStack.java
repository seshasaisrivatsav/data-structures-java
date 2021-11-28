package stacksAndQueues;

import java.util.Stack;

/*
    Write a program to sort a stack such that the smallest items are on the top. You can use
    an additional temporary stack, but you may not copy the elements into any other data structure
    (such as an array). The stack supports the following operations: push, pop, peek, and isEmpty.
 */
public class SortStack {

    /**
     * Approach: We keep a temp stack which always has highest value on top.
     *           We use the main stack to hold on to and also use to shuffle elements
     *           Once transfer is done, move elements back to main stack
     *  Time Complexity: O(n2)
     *  Space Complexity: O(n)
     * @param s1
     * @return
     */
    public Stack<Integer> sortedStack(Stack<Integer> s1) {
        Stack<Integer> s2 = new Stack<Integer>();
        while (!s1.isEmpty()) {
            int temp = s1.pop();
            while((!s2.isEmpty()) && s2.peek() > temp) {
                s1.push(s2.pop());
            }
            s2.push(temp);
        }
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        return s1;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        SortStack sortStack = new SortStack();
        Stack<Integer> sortedStack = sortStack.sortedStack(stack);
        System.out.println(sortedStack.peek());
    }
}
