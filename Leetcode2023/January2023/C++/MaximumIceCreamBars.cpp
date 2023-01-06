// https://leetcode.com/problems/maximum-ice-cream-bars/
class Solution {
public:
    // TC: O(nlogn)
    // SC: O(1)
    int maxIceCream(vector<int>& costs, int coins) {        
        sort(costs.begin(), costs.end());
        
        int count = 0;
        for (int cost : costs) {
            if (coins < cost) {
                break;
            }
            count++;
            coins -= cost;            
        }
        
        return count;        
    }
};
