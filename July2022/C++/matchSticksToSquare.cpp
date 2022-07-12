class Solution {
   // Recursion + Backtracking approach 
   // Here we are trying to make a subsequence of whose addition is sum/4 which means it can be divided into 4 equal part(condtion for square)
   // Therefore here in recursion we are trying to make all possibilities to make addition equals to sum/4 
   // Why reverse sorted array -> Reverse sorted array is just a small optimization by which we can easily check if our sum becomes greater than actual sum 
   // We have bigger elements sum of this array which restrict recursion to make unnecesaary calls in the initial phase only. 
    private:
    int f(int i,int sum,vector<int> &vis, vector<int> &nums,int cur_sum,
          int square,int n)
    {
        if(square==0) return 1; // able to make square 
        if(cur_sum == sum)  return f(0,sum,vis,nums,0,square-1,n);
        // able to make one side 
        if(i>=n) return 0;
        
        for(int j=i;j<n;j++)
        {
            if(!vis[j])
            {
                if(cur_sum+nums[j]<=sum) // cur_sum is becoming greater than actual
                {   
                    vis[j] = 1;
                    if(f(j+1,sum,vis,nums,cur_sum+nums[j],square,n)) return 1;
                    vis[j] = 0; // Backtrack
                }
            }
        }
        return 0;
    }
public:
    bool makesquare(vector<int>& nums) {
        
        int n = nums.size();
        long long sum = accumulate(nums.begin(),nums.end(),0);
        
        if(sum%4) return false;
        sort(nums.begin(),nums.end(),greater<>()); // Sorted in reverse order 
        vector<int> vis(n,0);
        
        return f(0,sum/4,vis,nums,0,4,n);
    }
};
