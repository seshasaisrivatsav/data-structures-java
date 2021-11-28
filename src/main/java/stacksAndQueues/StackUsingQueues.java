package stacksAndQueues;

import java.util.LinkedList;
import java.util.Queue;

// https://www.techiedelight.com/implement-stack-using-queue-data-structure/
// Note: Poll v/s remove - both are same where they remove the first element from queue but remove will return exception if element not present
public class StackUsingQueues {
    class StackUsingQueuesPushHeavy {
        Queue<Integer> q1 = new LinkedList<>(); // Used for popping element
        Queue<Integer> q2 = new LinkedList<>();

        public void push(int val) {
            q1.add(val);
        }

        /**
         *
         * Here we keep two queues
         * q1 = we just keep adding new elements to q1
         * q2 = to store pop. When ever pop is called, we transfer all but 1 element to q2, and store the single value, then swap q1 q2
         */
        public int pop() {
            // STEP 1: Transfer all but 1 element from q1 to q2 (If q1 is empty return -1)
            if (q1.isEmpty()) {
                return -1;
            }
            while (q1.size() != 1) {
                q2.add(q1.remove());
            }

            // STEP 2: Remember the value in q1
            int val = q1.remove();
            // STEP 3: Swap the queues
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
            return val;
        }
    }

    class StackUsingQueuesPopHeavy {
        Queue<Integer> q1 = new LinkedList<>(); // for pop return the front item from first queue
        Queue<Integer> q2 = new LinkedList<>(); // temp queue, used to transfer elements

        /*
            To push an item
                - we move all elements from first queue to second queue
                - then enqueue the new item into first queue
                - finally move all elements back to first queue - This ensure the top one always acts as popping
         */
        public void push(int data) {
            // STEP 1: move all elements from first to second queue
            while(!q1.isEmpty()) {
                q2.add(q1.peek()); // peek to add value
                q1.poll(); // remove it . Poll v/s Remove. poll doesn't throw exception
            }

            // STEP 2: push given data to first queue
            q1.add(data);

            // STEP 3: move all elements back to first queue
            while(!q2.isEmpty()) {
                q1.add(q2.peek());
                q1.poll();
            }
        }

        public int pop() {
            return q1.remove();
        }
    }
}

