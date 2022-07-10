class Solution {
public:
    int maxResult(vector<int>& nums, int k) {
        
        int n = nums.size();
        deque<int> q{0};
        
        for(int i=1;i<n;i++)
        {
            if(q.front()+k<i) q.pop_front(); 
            nums[i] += nums[q.front()];
            while(!q.empty() and nums[q.back()]<=nums[i]) // If nums[i] is greater than the q.back() means it is best optimal so far 
                q.pop_back();
            q.push_back(i);
        }
        return nums.back();
    }
};
