// https://leetcode.com/problems/find-original-array-from-doubled-array/
class Solution {
public:
    // TC: O(nlogn)
    // SC: O(n)
    vector<int> findOriginalArray(vector<int>& changed) {
        int n = changed.size();
        if (n % 2 != 0) {
            return {};
        }
        
        unordered_map<int, int> map;    // frequency
        for (auto it : changed) {
            map[it]++;
        }
        
        sort(changed.begin(), changed.end());
        
        vector<int> original;
        for (auto it : changed) {
            if (map[it] == 0) {
                continue;
            }
            if (map[it * 2] == 0) {
                return {};
            }
            map[it]--;
            map[it * 2]--;
            original.push_back(it);
        }
        
        return original;
    }
};
