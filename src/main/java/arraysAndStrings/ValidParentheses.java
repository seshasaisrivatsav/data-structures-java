package arraysAndStrings;

import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *      Open brackets must be closed by the same type of brackets.
 *      Open brackets must be closed in the correct order.
 */
public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println("((){(})) : False. Actual: " + isValid("((){(}))")); // Though brackets are matching, the order is incorrect
        System.out.println("(){()} : True. Actual: " + isValid("(){()}"));
        System.out.println("() : True. Actual: " + isValid("()"));
        System.out.println("()[]{} : True. Actual: " + isValid("()[]{}"));
        System.out.println("(] : false. Actual: " + isValid("(]"));
        System.out.println("(((((()))))) : true. Actual: " + isValid("(((((())))))"));
        System.out.println("()()()() : true. Actual: " + isValid("()()()()"));
        System.out.println("((()(()))) : true. Actual: " + isValid("((()(())))"));
        System.out.println("(((((((() : false. Actual: " + isValid("(((((((()"));
    }

    /**
     * For each opening bracket, we put a corresponding closing bracket in stack
     * When we get a closing bracket, if the stack is not empty or if the popped element is not same bracket
     *  Space Complexity: O(n)
     *  Time Complexity: O(n)
     * @param str String with brackets
     * @return boolean representing
     */
    public static boolean isValid(String str) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : str.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}
