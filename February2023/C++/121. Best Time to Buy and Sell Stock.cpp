class Solution {
public:
    int maxProfit(vector<int>& prices) {
        
        int profit=0;
        int min_value=INT_MAX;
        for(int i=0;i<prices.size();i++)
        {
            min_value=min(min_value,prices[i]);
            profit=max(profit,prices[i]-min_value);
            
        }
        return profit;
        
    }
};
