// @saorav21994

class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int [][] dp = new int[l1][l2];
        
        // using top-down approach dynamic-programming
        // if equal, (diagonal prev + 1)
        
        int res = 0;
        
        // first row initialize
        for (int i = 0; i < l2; i++) {
            if (nums1[0] == nums2[i]) {
                dp[0][i] = 1;
                res = Math.max(res, dp[0][i]);
            }
        }
        // first column initialize, dp[0][0] already accounted for
        for (int i = 1; i < l1; i++) {
            if (nums2[0] == nums1[i]) {
                dp[i][0] = 1;
                res = Math.max(res, dp[i][0]);
            }
        }
        // for (int []r : dp) {
        //     for (int c : r) {
        //         System.out.print(c +" ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();
        
        // fill out rest elements
        for (int i = 1; i < l1; i++) {
            for (int j = 1; j < l2; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = dp[i-1][j-1]+1;
                    res = Math.max(dp[i][j], res);
                }

            }
        }
        // for (int []r : dp) {
        //     for (int c : r) {
        //         System.out.print(c +" ");
        //     }
        //     System.out.println();
        // }
        return res;
    }
}


============================ Clean code ============================
    // author: anuj0503
    class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n+1][m+1];
        int ans = 0;
        
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= m; j++){
                if(nums1[i-1] == nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        
        return ans;
    }
}
