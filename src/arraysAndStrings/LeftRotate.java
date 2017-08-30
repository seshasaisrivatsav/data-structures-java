/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraysAndStrings;

/**
 *
 * @author seshasai
 */
public class LeftRotate {
    public static void main(String[] args){
        int[] A = {1,2,3,4,5};
        int rotations = 2;
        leftRotate(A, rotations);
    }
    
    public static void leftRotate(int[] A, int rotations){
        int newPos, temp;
        for(int i=0; i<A.length; i++){
            newPos = i-rotations;
           
            if(newPos >=0){
                temp = A[newPos-1];
                A[newPos]=A[i];
                A[i]=temp;
            }
            else{
                int newPos1 = A.length +newPos;
                temp=A[newPos1-1];
                A[newPos1]=A[i];
                A[i]=temp;
            }
        }
        for(int i=0; i<A.length;i++){
            System.out.println(A[i]);
        }
        
    }
    
}
