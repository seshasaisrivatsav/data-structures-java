package stacks;

public class StackMethodsTest {
	public static void main(String[] args) {
		Stack<Number> s = new Stack<Number>(6);
		 
		s.push(9);
		s.push(-1);
		s.push(11);
		 System.out.println(s.min());
	}
}
