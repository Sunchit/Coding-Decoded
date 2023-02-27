class Solution {
public:
    int minimumDeviation(vector<int>& nums) {
        
        int n = nums.size();
        priority_queue<int> pq;
        
        int mini = INT_MAX, maxi = INT_MIN;
        for(int i=0;i<n;i++)
        {
            if(nums[i]&1) nums[i] *=2;
            
            mini = min(nums[i], mini);
            maxi = max(nums[i], maxi);
            
            pq.push(nums[i]);
        }
        
        int ans = maxi-mini;
        while(pq.top()%2==0)
        {
            int x = pq.top(); pq.pop();
            ans = min(ans, x-mini);
            x /= 2;
            mini = min(mini, x);
            pq.push(x);
        }
        ans = min(ans, pq.top()-mini);
        return ans;
    }
};
