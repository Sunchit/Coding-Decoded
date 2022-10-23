
// @saorav21994

class Solution {
    public int[] findErrorNums(int[] nums) {
        
        /*
            Let x = missing element, y = duplicate element
            Then,
            diff = x-y;             -----> Eq. 1
            sum = x+y;
            Sq. of each diff = x^2-y^2 = (x+y)(x-y);        -----> Eq. 2
            So, sum = Sq. of each diff/diff = (Eq. 2)/(Eq. 1)   -----> Eq. 3
            Using, 
            Eq. 1 and Eq. 3, solving them linearly,
            2x = sum+diff
            or, x = (sum+diff)/2;
            and y = (sum-diff)/2;
        
        */
        
        int diff = 0, sum = 0, eachSqDiff = 0;
        
        for (int i = 0; i < nums.length; i++) {
            diff += ((i+1)-nums[i]);        /* index is zero based */
            eachSqDiff += ((i+1)*(i+1) - (nums[i])*(nums[i]));
        }
        
        sum = (int) eachSqDiff / diff;
        
        return new int [] {(sum-diff)/2, (sum+diff)/2};
        
    }
}
