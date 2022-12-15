class Solution {
public:
    int rob(vector<int>& nums) {
        
        int numHouses = nums.size();
        
        if(numHouses ==1){
            return nums[0];
        }
        
        int prevHouse1 = nums[0];
        

        
        int ans = max(nums[0], nums[1]);
                int prevHouse2 = ans;
        for(int house =2; house < numHouses; house++){
            
            ans = max( nums[house] + prevHouse1,prevHouse2);
            prevHouse1 = prevHouse2;
            prevHouse2 = ans;
            
        }
        
        return ans;
    }
};