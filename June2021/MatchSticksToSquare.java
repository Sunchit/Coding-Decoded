//https://leetcode.com/problems/matchsticks-to-square/

// Solution 1: Time Limit Exceeding

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

// Solution 2: Accepted

class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int matchstick : matchsticks)
            sum += matchstick;
        
        if (sum % 4 != 0) // The four sides cannot be equal
            return false;
        
        int sideLen = sum / 4;
        int[] sides = new int[] {sideLen, sideLen, sideLen, sideLen};
        
        Arrays.sort(matchsticks); // Always try longer matchstick first
        return helper(matchsticks, sides, matchsticks.length - 1); // idx starts from right to left
    }
    
    private boolean helper(int[] matchsticks, int[] sides, int idx) {
        if (idx == -1) // use up matchstick
            return allZero(sides);
        
        for (int i = 0; i < sides.length; i++) { // for each matchstick, try four sides
            if (matchsticks[idx] <= sides[i]) {
                sides[i] -= matchsticks[idx];
                if(helper(matchsticks, sides, idx - 1))
                    return true;
                sides[i] += matchsticks[idx]; // backtrack
            }
        }
        
        return false;
    }
    
    private boolean allZero(int[] sides) {
        for (int i = 0; i < sides.length; i++) {
            if (sides[i] > 0)
                return false;
        }
        return true;
    }
}
