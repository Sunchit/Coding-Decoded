class Solution {
public:
    int dp[101][101][21]; //m target colour
    
    int f(int ind, int t, int prev, vector<int> 
          &houses,vector<vector<int>>& cost,int target)
    {
        if(ind == houses.size())
        {
            if(t == target) return 0;
            return INT_MAX/2;
        }
        
        if(ind > houses.size()) return INT_MAX/2;
        
        if(dp[ind][t][prev] != -1) return dp[ind][t][prev];
        
        int ans = INT_MAX/2;

        if(houses[ind])  // If house is already painted check if prev colour is same or not if not incerement target
        {
            if(houses[ind]!=prev) ans = 
                f(ind+1,t+1,houses[ind],houses,cost,target);
            else ans = f(ind+1,t,houses[ind],houses,cost,target);
        }
        else 
        {
            for(int i=0;i<cost[0].size();i++) // trying all the colors for house 
            {
                int x = 0;
                if(prev == i+1) x = cost[ind][i]+
                    f(ind+1,t,i+1,houses,cost,target);  
                else x = cost[ind][i]+
                    f(ind+1,t+1,i+1,houses,cost,target);
                
                ans = min(ans, x);
            }
        }
        return dp[ind][t][prev] = ans;
    }
    
    int minCost(vector<int>& houses, vector<vector<int>>& cost, int m, int n, int target) {
        
        memset(dp, -1, sizeof(dp));
        int ans = f(0,0,0,houses,cost,target);
        if(ans == INT_MAX/2) return -1;
        return ans;
    }
};
