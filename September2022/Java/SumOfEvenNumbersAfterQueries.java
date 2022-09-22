
// @saorav21994

class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
    
        int sum = 0;
        for (int ele : nums) {
            if (Math.abs(ele)%2 == 0)     // sum of all even numbers present in the nums array
                sum += ele;
        }
                
        int q = queries.length;
        int l = nums.length;
        
        int [] res = new int[q];
        
        for (int i = 0; i < q; i++) {
            
            int idx = queries[i][1];
            int val = queries[i][0];
            
            int cur = nums[idx];
            if (Math.abs(cur)%2 == 0) {
                sum -= cur;
            }
            
            int new_val = cur + val;
            nums[idx] = new_val;
            
            // System.out.println("cur = " + cur + " new_val = " + new_val);
            
            if (Math.abs(new_val)%2 == 0) {
                sum += new_val;
            }
            
            res[i] = sum;
            
            // for (int ele : nums) {
            //     System.out.print(ele+ " ");
            // }
            // System.out.println();
            
        }
        
        return res;
        
    }
}
