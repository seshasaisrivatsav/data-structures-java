/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopsConcepts;

/**
 *
 * @author seshasai
 */
public class Inheritance_new extends Calculation{
    static int z;
    
     public static void multiplication(int x, int y) {
      z = x * y;
      System.out.println("The product of the given numbers:"+z);
   }
	
   public static void main(String args[]) {
      int a = 20, b = 10;
      Inheritance_new demo = new Inheritance_new();
      demo.addition(a, b);
      demo.Subtraction(a, b);
      demo.multiplication(a, b);
    
}
}

class Calculation {
   int z;
	
   public void addition(int x, int y) {
      z = x + y;
      System.out.println("The sum of the given numbers:"+z);
   }
	
   public void Subtraction(int x, int y) {
      z = x - y;
      System.out.println("The difference between the given numbers:"+z);
   }
}
