package stacks;

import java.util.Scanner;
import java.util.Stack;

public class BracketProblem {


	public static void main(String[] args) {
	
		Scanner sc = new Scanner (System.in);
		System.out.println("ENter a String with brakcets");
		String i = sc.nextLine();
		
		
		System.out.println(equalBracket(i));
		
		
	}
	
	
	public static Boolean equalBracket(String str){
		Boolean yea=false;
		char temp;
		//inbuilt stack initialization
		Stack<Character> stk = new Stack();
		
		for(int i=0; i<str.length(); i++) {
			temp = str.charAt(i) ;
			if(temp == '(' || temp  == '{' ||temp  == '[') {
				stk.push(str.charAt(i));
			}else {
				temp = stk.peek();
				if(temp == '(' && str.charAt(i) == ')'
						|| temp == '[' && str.charAt(i) == ']'
						|| temp == '{' && str.charAt(i) == '}'
						) {
					stk.pop();
					}else {
						stk.push(str.charAt(i));
					}
			}
			
		}
		
		if(stk.isEmpty()) {
			return true;
		}
		return false;
		 
	}
	
}
