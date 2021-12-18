package general;


public class Fibonacci {

    public static void main(String[] args){
        int n = 8;
        System.out.println(n+" th fibonacci is "+ fibIteration(n));
        System.out.println(fibRecurse(8));
    }

    public static int fibIteration(int n){
        int x=0, y=1, z=1;
        for(int i=0; i<n; i++){
            x=y;
            y=z;
            z=x+y;
        }
        return x;
    }

    public static int fibRecurse(int n){
        if(n==0 || n==1){
            return n;
        }
        else {
            return fibRecurse(n-1)+ fibRecurse(n-2);
        }
    }
}
