package stacksAndQueues;

/*
    Design a stack such that it also has a method to return min.
    All the operations push, pop and min should operate in O(1)

    An Approach: Modify stackNode to have min, where we check each push for min.
    Better Approach: Keep additional stack to track the mins
 */
public class StackMin extends MyStack<Integer> {
    MyStack<Integer> minStack;

    public StackMin() {
        minStack = new MyStack<Integer>();
    }

    public int min() {
        if(minStack.isEmpty()) return Integer.MAX_VALUE;
        return minStack.peek();
    }

    public void push(int value) {
        if (value < min()) {
            minStack.push(value);
        }
        super.push(value);
    }

    public Integer pop() {
        int value = super.pop();
        if (value == min()) {
            minStack.pop();
        }
        return value;
    }

    public static void main(String[] args) {
        StackMin stackMin = new StackMin();

        stackMin.push(9);
        stackMin.push(6);
        stackMin.push(7);
        System.out.println("expecting 6:" + stackMin.min()); // should return 6
        stackMin.push(5);
        System.out.println("expecting 5:" +stackMin.min()); // should return 5
        stackMin.pop();
        stackMin.pop();
        stackMin.pop();
        System.out.println("expecting 9:" +stackMin.min()); // should return 5

    }
}
