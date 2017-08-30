package general;


public class FibonacciIterative {
    
    public static void main(String[] args){
        
        int n = 8;
        System.out.println(n+" th fibonacci is "+ fibIteration(n));
    }
    
    public static int  fibIteration(int n){
        int x=0, y=1, z=1;
        for(int i=0; i<n; i++){
            x=y;
            y=z;
            z=x+y;
        }
        return x;
        
    }
    
}
