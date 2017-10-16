package stacks;

import java.util.Arrays;

public class ThreeStacksUsingSingleArray {
	
	// three stack in array
	public static class StackUsingOneArray{
		int[] stack;
		int[] tops;
		int[] stackSizes;
		
		public   StackUsingOneArray(int numOfStacks, int[] stackSizes){

			int totalSize=0;
			tops = new int[numOfStacks];
			
			
			for(int i=0; i<stackSizes.length;i++) {
				if(i==0) {
					tops[i]=-1;
				}else {
					tops[i]=tops[i-1]+stackSizes[i-1];
				}
				totalSize += stackSizes[i];
				
			} 	
			
			stack = new int[totalSize];
			
		}
		
		public int peek(int stkNr) {
			return stack[tops[stkNr]];
		}
		
		public void push(int stkNr, int element) {
			stack[++tops[stkNr]] = element;
		}
		
		public int pop(int stkNr) {
//			int a= stack[tops[stkNr]];
//			stack[tops[stkNr]] = (Integer) null;
//			tops[stkNr]--;
//			return a;
			return stack[tops[stkNr]--];
		}
		
		public boolean isEmpty(int stkNr) {
			
			if(stkNr==0 && tops[0]==-1) {
				return true;
			}
			int i = 0;
			int s = -1;
			while(i < stkNr) {
				s+= stackSizes[i];
			}
			if(tops[stkNr]== s) {
				return true;
			}
			
			return false;
		}
		
		public boolean isFull(int stkNr) {
			int ptr=0;
			for(int i=0; i<=stkNr;i++) {
				ptr+=stackSizes[i];
			}
			if(tops[stkNr]==ptr-1) {
				return true;
			}
			return false;
		}
	}
	// firstcreat
	public static void main(String[] args) {
		
		int[] stackSizes = {2, 3, 5};
		StackUsingOneArray stk = new StackUsingOneArray(3, stackSizes );
		System.out.println(Arrays.toString(stk.tops) );
		stk.push(0, 1);
		stk.push(1, 1); stk.push(1, 2);
		stk.push(2, 3);		stk.push(2, 3);		stk.push(2, 3);
		
		System.out.println(Arrays.toString(stk.tops) );
		
		
		System.out.println(stk.pop(1));

		System.out.println(stk.pop(1));
		
 
		//System.out.println(stk.isEmpty(1));
	}

}
