package stacksAndQueues;

public class MyStackUsage {
    public static void main(String[] args) {
        StackMin stackMin = new StackMin();

        stackMin.push(9);
        stackMin.push(6);
        stackMin.push(7);
        System.out.println("expecting 6:" + stackMin.min()); // should return 6
        stackMin.push(5);
        System.out.println("expecting 5:" +stackMin.min()); // should return 5
        stackMin.pop();stackMin.pop();stackMin.pop(); // removing three elements
        System.out.println(stackMin.min()); // should return 9

        MyStack<Integer> myStack = new MyStack<Integer>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.print());

    }
}
