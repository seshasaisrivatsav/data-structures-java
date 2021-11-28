package stacksAndQueues;

import java.util.EmptyStackException;

/**
 * Describe how to implement 3 stacks using a single array
 * Approach 1: Fixed Array Division = Divide array into 3 spaces and use as stack. It can run into issues where one
 *             stack can be full while others are empty
 * Approach 2: Variable Array = Dynamically update stacks
 */
public class SingleArrayToImplement3Stacks {

    /**
     * Approach 1: Fixed Division
     * For Stack 1 - use [0, n/3)
     * For Stack 2 - use [n/3, 2n/3)
     * For Stack 2 - use [n/3, 2n/3)
     */
    class FixedMultiStack {
        private int NUM_OF_STACKS = 3;
        private int stackCapacity; // Each stack size
        private int[] stackValues; // Where the data stores
        private int[] stackSizes; // indicates the current size of stack

        /**
         * Let's say we have 3 stacks of size=4=stackCapacity
         * Then each stack goes from
         *  0 to 4
         *  4 to 8
         *  8 to 12
         *      Starting index = (stack number) X (Stack Capacity)
         * @param stackNum stack number
         * @return int index of top element
         */
        private int getIndexOfTop(int stackNum) {
            int startingIndex = stackNum * stackCapacity;
            int currentStackSize = stackSizes[stackNum]; // if we're in second one 0, 1, 2, 3 | 4, 5, 6, 7 | 8, 9, 10, 11
            return startingIndex + currentStackSize - 1;
        }

        public FixedMultiStack(int stackCapacity) {
            this.stackCapacity = stackCapacity;
            stackValues = new int[NUM_OF_STACKS * stackCapacity];
            stackSizes = new int[NUM_OF_STACKS];
        }


        public boolean isFull(int stackNum) {
            return stackSizes[stackNum] == stackCapacity;
        }

        public boolean isEmpty(int stackNum) {
            return stackSizes[stackNum] == 0;
        }

        public void push(int stackNum, int data) {
            if (isFull(stackNum)) throw new EmptyStackException();
            // first increment the stack sizes and then get index of top
            stackSizes[stackNum]++;
            stackValues[getIndexOfTop(stackNum)] = data;
        }

        public int peek(int stackNum) {
            if (isEmpty(stackNum)) throw new EmptyStackException();
            return stackValues[getIndexOfTop(stackNum)];
        }

        public int pop(int stackNum) {
            if (isEmpty(stackNum)) throw new EmptyStackException();
            int indexOfTop = getIndexOfTop(stackNum);
            int res = stackValues[indexOfTop];
            stackValues[indexOfTop] = 0; // clear the value
            stackSizes[stackNum]--; // reduce that stack size
            return res;
        }
    }

    public class FlexibleMultiStack {
        // TODO: come up with solution
    }

}
