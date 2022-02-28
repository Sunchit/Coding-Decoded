
// @saorav21994
// TC : O(n)


class Solution {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> res = new ArrayList<String>();
        StringBuffer str = new StringBuffer("");
        if (n == 0) {
            return res;
        }
        str.append(String.valueOf(nums[0]));
        int last = nums[0];
        for (int i = 1; i < n; i++) {
            if (Math.abs(nums[i] - nums[i-1]) != 1) {
                if (last != nums[i-1]) {
                    str.append("->");
                    str.append(String.valueOf(nums[i-1]));
                }
                res.add(String.valueOf(str));
                str = new StringBuffer("");
                str.append(String.valueOf(nums[i]));
                last = nums[i];
            }
        }
        if (last != nums[n-1]) {
            str.append("->");
            str.append(String.valueOf(nums[n-1]));
        }
        res.add(String.valueOf(str));
        return res;
    }
}
