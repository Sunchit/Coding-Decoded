class Solution {

    // TC : O(n)
    // SC : O(1)
    public int fib(int N) {

        if(N <= 1)
            return N;

        int a = 0, b = 1;

        int sum = a + b;
        for(int i=2;i<=N;i++)
        {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }


    // TC : O(n)
    // SC : O(n)
    public int fib(int n) {
        if(n<=1){
            return n;
        }
        int[] dp = new int[n+1];

        dp[0] =0;

        dp[1] =1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];

    }


    // TC : O(n)
    // SC : O(n)
    // <N , fib(N)>
     Map<Integer, Integer> map = new HashMap<>();

     public int fib(int n) {
         if(map.containsKey(n)){
             return map.get(n);
         }
         if(n==0){
             return 0;
         } else if(n==1){
             return 1;
         } else{
             int fibNo = fib(n-1) + fib(n-2);
             map.put(n, fibNo);
             return fibNo;
         }
     }

    public int fib(int n) {
        if(n==0){
            return 0;
        } else if(n==1){
            return 1;
        } else{
            return fib(n-1) + fib(n-2);

        }
    }



}