// TC  O(N)
// SC O(1)
class Solution {
    public int tribonacci(int n) {
        if(n==0){
            return 0;
        }
        else if(n<=2){
            return 1;
        } else {
            // n is greater equal to 3
            int a = 0;
            int b = 1;
            int c = 1;
            int index =3;
            int sum = 0;

            while(index<=n){
                sum  = a+b+c;
                index++;
                a=b;
                b = c;
                c =sum;
            }
            return sum;

        }


    }
}
// -> Recursive approach (With/Without memoization)
// -> DP int[]
// -> Current Approach


