class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<int> temp;
        vector<vector<int>> res;
        dfs(nums,temp,res,0);
        res.push_back({});
        return res;
    }
    void dfs(vector<int>& nums,vector<int> temp,vector<vector<int>>& res,int idx)
    {
        if(idx==nums.size())  return ;
        
        for(int i=idx;i<nums.size();i++)
        {
            temp.push_back(nums[i]);
            res.push_back(temp);
            dfs(nums,temp,res,i+1);
            temp.pop_back();
        }
    }
};