// https://leetcode.com/problems/minimum-time-to-make-rope-colorful/
// TC - O(N)
// SC - O(1)
class Solution {
public:
    int minCost(string colors, vector<int>& neededTime) {
        
        int  n = colors.size();
       
        int maxi = INT_MIN;
        int currSum = 0;
        int totalVal = 0;
        
        // traversing 
        for(int i=0;i<n;i++){
            
            maxi = INT_MIN;
            // finding maximum from the group of consecutive same colors
            while((i<n-1 && colors[i]==colors[i+1])){
                maxi = max(neededTime[i],maxi);
                // maintaining total Sum for the current group
                   currSum += neededTime[i];
                i++;
            }
            if(i>0 && colors[i]==colors[i-1]){
              
                   currSum += neededTime[i];
                  maxi=    max(neededTime[i],   maxi);
                // Excluding maximum and adding remaining total time in answer
                totalVal += currSum - maxi;
               
                
            }
             currSum = 0;
           
        }
        return totalVal;
    }
};