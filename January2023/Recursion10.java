
public class Recursion10 {

    public static int tilingProblem(int n){

        if(n==0||n==1){
            return 1;
        }

        // vertical choice
        int fnm1 = tilingProblem(n-1);

        // horizontal choice
        int fnm2 = tilingProblem(n-2);

        int toalWays = fnm2 +fnm1;

        return toalWays;

    }

    public static void main(String[] args) {
        System.out.println(tilingProblem(9));
    }
}
