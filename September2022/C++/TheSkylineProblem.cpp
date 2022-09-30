// https://leetcode.com/problems/the-skyline-problem/
class Solution {
private:
    void transformBuildings(vector<vector<int>> &buildings, vector<pair<int, int>> &heights) {
        for (auto building : buildings) {
            heights.push_back({building[0], -building[2]});
            heights.push_back({building[1], building[2]});
        }
    }

public:
    // TC: O(nlogn)
    // SC: O(n)
    vector<vector<int>> getSkyline(vector<vector<int>> &buildings) {
        vector<vector<int>> res;
        vector<pair<int, int>> heights;

        transformBuildings(buildings, heights);
        sort(heights.begin(), heights.end());

        multiset<int> m;
        m.insert(0);
        int prevMax = 0;

        for (auto height : heights) {
            if (height.second < 0) {
                m.insert(-height.second);
            } else {
                m.erase(m.find(height.second));
            }
            int currMax = *m.rbegin();
            if (currMax != prevMax) {
                res.push_back({height.first, currMax});
                prevMax = currMax;
            }
        }

        return res;
    }
};
