class Solution {
public:
    int maxIceCream(vector<int>& costs, int coins) {
        
        int n = costs.size();
        sort(costs.begin(),costs.end());
        int ans = 0;
        
        for(int i=0;i<n;i++)
        {
            if(coins-costs[i]>=0)
            {
                ans++;
                coins -= costs[i];
                if(coins<0) return ans;
            }
            else break;
        }
        return ans;
    }
};          
