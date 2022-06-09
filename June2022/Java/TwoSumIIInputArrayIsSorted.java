
// @saorav21994
// TC : O(n)
// SC : O(1)

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int l = 0, h = n-1;
        while (l < h) {
            int sum =  numbers[l] + numbers[h];
            if (sum == target)
                return new int[] {l+1, h+1};
            else if (sum < target) {
                l += 1;
            }
            else {
                h -= 1;
            }
        }
        return new int[] {-1,-1};
    }
}
