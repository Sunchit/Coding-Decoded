class Solution {

    // TC : O(n)
    // SC : O(1)
    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        int low =1;
        int high = k+1;
        for(int i=0;i<k+1;i++){
            if(i%2==0){
                ans[i] = low;
                low++;
            } else{
                ans[i] = high;
                high--;
            }
        }

        for(int i=k+1;i<n;i++){
            ans[i] = i+1;
        }

        return ans;

    }
}