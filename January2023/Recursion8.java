public class Recursion8 {
    
    public static int printxPowerN(int a, int n){
        if(n==0){
            return 1;
        }
       
       
        return a *printxPowerN(a, n-1);
    }

    public static void main(String[] args) {
        System.out.println(printxPowerN(2, 10));
    }


}
