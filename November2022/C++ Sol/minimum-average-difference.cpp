class Solution {
public:
    int minimumAverageDifference(vector<int>& nums) {
        
        long long len = nums.size();
        long long totalSum = nums[0];
        vector<long long>prefixSum(len);
        prefixSum[0]  = nums[0];
        
        for(long long index = 1; index < len; index++){
            
            prefixSum[index] = prefixSum[index-1] + nums[index];
            totalSum += nums[index];
        }
        
       long long minAvgDiff = INT_MAX;
       long long minIndex = -1;
        
        for(long long index = 0; index < len; index++){
            
             long long currAvgDiff = INT_MAX;
            
            if(index == len-1){
                
                  currAvgDiff  = (prefixSum[index]/(index+1));
            }
            else{
                
             currAvgDiff  = abs((prefixSum[index]/(index+1))   -  ((totalSum-prefixSum[index])/(len-index-1))) ;
            
            }

            if(currAvgDiff < minAvgDiff){
                
                minAvgDiff = currAvgDiff;
                minIndex = index;
            }
        }
        
        return minIndex;
    }
    
};class Solution {
public:
    int minimumAverageDifference(vector<int>& nums) {
        
        long long len = nums.size();
        long long totalSum = nums[0];
        vector<long long>prefixSum(len);
        prefixSum[0]  = nums[0];
        
        for(long long index = 1; index < len; index++){
            
            prefixSum[index] = prefixSum[index-1] + nums[index];
            totalSum += nums[index];
        }
        
       long long minAvgDiff = INT_MAX;
       long long minIndex = -1;
        
        for(long long index = 0; index < len; index++){
            
             long long currAvgDiff = INT_MAX;
            
            if(index == len-1){
                
                  currAvgDiff  = (prefixSum[index]/(index+1));
            }
            else{
                
             currAvgDiff  = abs((prefixSum[index]/(index+1))   -  ((totalSum-prefixSum[index])/(len-index-1))) ;
            
            }

            if(currAvgDiff < minAvgDiff){
                
                minAvgDiff = currAvgDiff;
                minIndex = index;
            }
        }
        
        return minIndex;
    }
    
};