class Solution {
public:
    // time = O(n) + O(n) + O(n) (for sum) =~ O(n)
    // space = O(n)    
    int candy(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> candies(n, 1); //Intinially give all childs 1 candy 
        
        for(int i=1; i<n; i++)
        {
            if(nums[i-1] < nums[i]) candies[i] = candies[i-1] + 1;
        }
        
        for(int i=n-2; i>=0; i--)
        {
            if(nums[i] > nums[i+1])
                candies[i] = max(candies[i], candies[i+1] + 1); 
                //if candies[i] is already max than candies[i]+1 
        }
        
       return accumulate(candies.begin(), candies.end(), 0); 
    }
};
