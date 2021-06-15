//https://leetcode.com/problems/matchsticks-to-square/

class Solution {

    // TC : O(4^N)
    public boolean makesquare(int[] nums) {
        if (nums.length < 4) return false;

        int perimeter = 0;
        for (int el : nums)  {
            perimeter += el;
        }

        if (perimeter % 4 != 0) return false;

        Arrays.sort(nums);
        int side = perimeter / 4;
        int[]  sides = new int[] {side, side, side, side};

        return makesquareHelper(nums, 0, sides);
    }

    private boolean makesquareHelper(int[] nums, int i, int[] sides) {
        if(i == nums.length) {

            if(sides[0] == 0 && sides[1] == 0 && sides[2] == 0 && sides[3] == 0){
                return true;
            } else{
                return false;
            }
        }


        for (int j = 0; j < 4; j++) {
            if (nums[i] > sides[j]) continue;
            sides[j] -= nums[i];
            if (makesquareHelper(nums, i + 1, sides)) return true;
            sides[j] += nums[i];
        }

        return false;
    }
}