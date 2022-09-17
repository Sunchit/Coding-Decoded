
// @saorav21994
// TC : O(logn)
// SC : O(1)

class Solution {
public:
    int brokenCalc(int startValue, int target) {
        int res = 0;
        while (target > startValue) {
            if (target&1)
                target += 1;
            else
                target >>= 1;
            res += 1;
        }
        res += (startValue - target);
        return res;
    }
};
