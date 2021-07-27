/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopsConcepts;
import java.util.*;
/**
 *
 * @author seshasai
 */
public class Inheritance {
    
    private int A=66 ;
 
    
    public int getA(){
        return A;
    }
    
    public void setA(int AA){
        A = AA;
        
    }
    
    
     private String name;
      public String getName() {
      return name;
   }
      
         public void setName(String newName) {
      name = newName;
   }

    
    
    public static void main(String[] args){
       Inheritance i = new Inheritance();
       //i.setA(5);
       
         i.setName("adfgsdfg");
       System.out.print( i.getA());
       
    }
    
}
