class Solution {
public:
    bool isPossible(vector<int>& nums) {
        int n=nums.size();
      
        unordered_map<int,int> availability;
        for(auto i:nums) availability[i]++;
        
        unordered_map<int ,int> endings;
      
        for(int i=0;i<n;i++){
            int curr=nums[i];
            if(availability[curr]==0) continue;
            else if(endings[curr-1]>0){
                availability[curr]--;
                endings[curr-1]--;
                endings[curr]++;
            }else if(availability[curr+1]>0&&availability[curr+2]>0){
                availability[curr]--;
                availability[curr+1]--;
                availability[curr+2]--;
                endings[curr+2]++;
            }
            else{
                return false;
            }
        }
        return true;
    }
};
