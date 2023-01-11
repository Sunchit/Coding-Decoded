

public class Recursion2 {
    // print factorial of a number

    public static void main(String[] args) {
        int n = 5;
        System.out.println(factorial(n));
       
    }
    
    public static int factorial(int n){

        if(n==0){
            return 1;
        }

        factorial(n-1);
        int fn = n *factorial(n-1);

        return fn;
    }
   


}

