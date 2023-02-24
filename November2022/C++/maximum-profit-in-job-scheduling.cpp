class Solution {
     int getNextIndex(vector<vector<int>>& array, int l, int currentJobEnd) {
         int n = array.size();
        int r = n-1;
        
        int result = n+1;
        
        while(l <= r) {
            int mid = l + (r-l)/2;
            
            if(array[mid][0] >= currentJobEnd) { //we can take this task
                result = mid;
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        
        return result;
    }
   
    int find(vector<int>&dp,vector<vector<int>>&time,int index){
        
        if(index>=time.size()){
            return 0;
        }
        
        if(dp[index]!= -1){
            return dp[index];
        }
        
        int take = 0;
        int notTake = 0;
        int in = getNextIndex(time,index+1,time[index][1]);

           take = time[index][2] + find(dp,time,in);    
       notTake= find(dp,time,index+1);
        
        return dp[index] = max(take,notTake);
    }
    
public:
    int jobScheduling(vector<int>& startTime, vector<int>& endTime, vector<int>& profit) {
 
        int n  = startTime.size();
        vector<vector<int>>time;
        for(int i=0;i<n;i++){
            time.push_back({startTime[i],endTime[i],profit[i]});
        }
        sort(time.begin(),time.end());
       vector<int>dp(n+1,-1);
 
         return    find(dp,time,0);
    
    }
};