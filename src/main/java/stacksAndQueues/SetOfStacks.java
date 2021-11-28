package stacksAndQueues;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * : Imagine a (literal) stack of plates.
 *      If the stack gets too high, it might topple.
 *      Therefore, in real life, we would likely start a new stack when the previous stack exceeds some
 *       threshold.
 *      Implement a data structure SetOfStacks that mimics this. SetOfStacks should be composed of several stacks and
 *          should create a new stack once the previous one exceeds capacity.
 *   SetOfStacks. push () and
 *   SetOfStacks. pop()     should behave identically to a single stack
 * (that is, pop ( ) should return the same values as it would if there were just a single stack).
 * FOLLOW UP
 * Implement a function popAt (int index) which performs a pop operation on a specific substack.
 */
public class SetOfStacks {
    ArrayList<Stack<Integer>> stacks = new ArrayList<Stack<Integer>>();
    public int stackCapacity;
    public SetOfStacks(int stackCapacity) {
        this.stackCapacity = stackCapacity;
    }

    public Stack<Integer> getLastStack() {
        if (stacks.size() == 0) {
            return null;
        }
        return stacks.get(stacks.size() - 1);
    }

    public void push(int v) {
        Stack<Integer> lastStack = getLastStack();
        if (lastStack != null) {
            lastStack.push(v);
        } else {
            Stack<Integer> newStack = new Stack<Integer>();
            newStack.push(v);
            stacks.add(newStack);
        }
    }

    public int pop() {
        Stack<Integer> lastStack = getLastStack();
        if (lastStack == null) {
            throw new EmptyStackException();
        }
        int popValue = lastStack.pop();
        if (lastStack.size() == 0) {
            stacks.remove(stacks.size() -1);
        }
        return popValue;
    }


    // TODO: To code more, but will read in CTCI
}
