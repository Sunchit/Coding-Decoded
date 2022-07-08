class Solution {
public:
    // Avarage TC = O(n)
    // Space = O(n)
    int longestConsecutive(vector<int>& nums) {
        
        int n = nums.size();
        
        unordered_set<int> s(nums.begin(),nums.end());
            // Inserted vector into a unordered set
        int ans = 0;
        
        for(int i=0;i<n;i++)
        {
            int x = nums[i];
            if(s.find(x-1)==s.end()) // Check if x is start of the sequence  
            {
                while(s.find(x)!=s.end()) x++;
            }
            ans = max(ans,x-nums[i]);
        }
        return ans;
    }
};
