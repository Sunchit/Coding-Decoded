public class Recursion3 {
    public static void main(String[] args) {
        int n = 10;
      System.out.println(sumOfNaturalNumbers(n));
    }
    public static int sumOfNaturalNumbers(int n){
       if(n==1){
        return 1;
       }
      
        int sum = n + sumOfNaturalNumbers(n-1);
        sumOfNaturalNumbers(n-1);
      

      return sum;

       
       
       
        

    }

}

