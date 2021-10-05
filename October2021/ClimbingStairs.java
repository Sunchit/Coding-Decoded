class Solution {
    //stores the no. of ways to reach the top from intermediate steps
    Integer dp[];
    private int climb(int n,int steps){
        if(steps==n) return 1;
        if(steps>n) return 0;
        if(dp[steps]!=null) return dp[steps];
        
        int w1=climb(n,steps+1);
        int w2=climb(n,steps+2);
        return dp[steps]=w1+w2;
    }
    
    public int climbStairs(int n) {
        dp=new Integer[n];
        // dp[0] will store the no. of ways to reach the top(nth step) from 0th step
        return climb(n,0);
    }
}