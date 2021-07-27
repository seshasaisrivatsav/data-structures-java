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

public class Dog extends Animal{
   
    public void move(int speed){
        System.out.println("dog can run at "+ speed);
    }
   
    public static void main (String[] args){
       Animal a1 = new Animal();
       Animal a2 = new Dog();
       a1.move(5);
       a2.move(5);
   }
    
}


