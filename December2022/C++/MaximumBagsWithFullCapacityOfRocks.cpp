// https://leetcode.com/problems/maximum-bags-with-full-capacity-of-rocks/
class Solution {
public:
    // TC: O(nlogn)
    // SC: O(n)
    int maximumBags(vector<int>& capacity, vector<int>& rocks, int additionalRocks) {
        int n = capacity.size();
        vector<int> remainingCapacity(n);

        for (int i = 0; i < n; i++) {
            remainingCapacity[i] = capacity[i] - rocks[i];
        }
        sort(remainingCapacity.begin(), remainingCapacity.end());

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (additionalRocks >= remainingCapacity[i]) {
                additionalRocks -= remainingCapacity[i];
                ans++;
            } else {
                break;
            }
        }

        return ans;
    }
};
