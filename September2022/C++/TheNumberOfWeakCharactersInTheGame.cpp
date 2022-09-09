// https://leetcode.com/problems/the-number-of-weak-characters-in-the-game/
class Solution {
private:
    static bool comp(vector<int>& a, vector<int>& b) {
        if (a[0] != b[0]) {
            return a[0] < b[0];
        }    
        return a[1] > b[1];
    }
    
public:
    // TC: O(nlogn)
    // SC: O(1)
    int numberOfWeakCharacters(vector<vector<int>>& properties) {
        int n = properties.size();
        // sorting attack in ascending order and defence descending
        sort(properties.begin(), properties.end(), comp);
        
        int currMax = properties[n - 1][1];
        int count = 0;
        
        for (int i = n - 2; i >= 0; i--) {
            if (currMax > properties[i][1]) {
                count++;
            } else {
                currMax = properties[i][1];
            }
        }

        return count;
    }
};
