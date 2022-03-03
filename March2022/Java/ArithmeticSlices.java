
// @saorav21994
// TC : O(n)
// SC : O(1)

// iterate through the array, keep incrementing count whenever diff is same. If diff mismatch, calculate answer [ n*(n+1)/2 ] if count >= 3 and reset count variable to 2. Continue the process untill array end reached. After loop once again perform the same operation for calculating answer of the remaining count variable value.


class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int l = nums.length;
        if (l < 3)
            return 0;
        int count = 1;
        int answer = 0;
        int diff = nums[1] - nums[0];
        for (int i = 1; i < l; i++) {
            if ((nums[i] - nums[i-1]) == diff)
                count += 1;
            else {
                if (count >= 3)
                    answer += ((count-2) * (count-1)) / 2;
                //System.out.println(answer + " - " + count + " - " + nums[i]);
                count = 2;
                diff = nums[i] - nums[i-1];
            }
        }
        if (count >= 3) {
            answer += ((count-2) * (count-1)) / 2;
        }
        return answer;
    }
}
