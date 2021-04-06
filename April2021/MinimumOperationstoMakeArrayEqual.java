class Solution {
    // TC : O(n)
    // SC : O(1)
     public int minOperations(int n) {
         int ans = 0;
         for(int i=1;i<n;i=i+2){
             ans += (n-i);
         }
         return ans;
     }

    // TC : O(1)
    // TC : O(1)
    public int minOperations(int n) {
        if(n%2==1){
            // n is odd
            n =n /2;
            return n*(n+1);
        } else{
            // n is even
            n =n/2;
            return n*n;
        }
    }
}