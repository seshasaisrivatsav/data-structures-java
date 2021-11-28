package stacksAndQueues;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Implement MyQueue using two stacks
 */
public class QueueUsingTwoStacks {

    class MyQueuePushHeavyMainApproach {
        Stack<Integer> s1 = new Stack<>(); // the place where we push
        Stack<Integer> s2 = new Stack<>(); // this is the one which gives pop

        void enqueue(int data) {
            s1.push(data);
        }

        /**
         * If we simply reverse the elements in s1 to s2, by popping s2, we get desired dequeue effect
         * if s2 is empty,
         * @return int
         */
        int dequeue() {
            if (!s2.isEmpty()) {
                return s2.pop();
            }
            if (s1.isEmpty()) {
                throw new EmptyStackException();
            }
            while(s1.size() != 0) {
                int data = s1.peek();
                s2.push(data);
                s1.pop();
            }
            int res = s1.pop();
            while(!s2.isEmpty()) {
                s1.push(s2.pop());
            }
            return res;
        }

    }

    class MyQueuePushHeavy {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        void enqueue(int data) {
            s1.push(data);
        }

        int dequeue() {
            if (s1.isEmpty()) {
                throw new EmptyStackException();
            }
            while(s1.size() != 1) {
                int data = s1.peek();
                s2.push(data);
                s1.pop();
            }
            int res = s1.pop();
            while(!s2.isEmpty()) {
                s1.push(s2.pop());
            }
            return res;
        }

    }
}
