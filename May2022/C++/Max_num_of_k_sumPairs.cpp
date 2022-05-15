// https://leetcode.com/problems/max-number-of-k-sum-pairs/
// O(n) solution using map
class Solution {
public:
    int maxOperations(vector<int>& nums, int k) {
        int n = nums.size();
        unordered_map<int, int> mp;
        int ans = 0;
        for(int i = 0; i < n; i++)
        {
            if(mp.count(k - nums[i])){
                mp[k-nums[i]]--;
                if( mp[k-nums[i]] == 0)
                    mp.erase(k-nums[i]);
                ans++;
            }
            else{
                mp[nums[i]]++;
            }
        }
        return ans;
    }
};
