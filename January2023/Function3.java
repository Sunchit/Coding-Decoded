import java.util.Scanner;

public class Function3 {
    public static int factorial(int n){
        int fact = 1;

        for(int i=1;i<=n;i++){
            fact = fact*i;
        }

        return fact;


    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            int n = sc.nextInt();
            int r = sc.nextInt();
            int binomialDeno = factorial(r)*factorial(n-r);
            int binomial = (factorial(n)/binomialDeno);

            System.out.println("The Binomial Coffieient is: "+binomial);

          

        }
    }
}
