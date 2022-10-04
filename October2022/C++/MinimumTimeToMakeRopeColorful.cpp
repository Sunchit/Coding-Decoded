// https://leetcode.com/problems/minimum-time-to-make-rope-colorful/
class Solution {
public:
    // TC: O(n)
    // SC: O(1)
    int minCost(string colors, vector<int>& neededTime) {
        int n = colors.length();
        int time = 0;
        
        for (int i = 1; i < n; i++) {
            if (colors[i] == colors[i - 1]) {
                if (neededTime[i] < neededTime[i - 1]) {
                    time += neededTime[i];
                    neededTime[i] = neededTime[i - 1];
                } else {
                    time += neededTime[i - 1];
                }
            }
        }
        
        return time;
    }
};
