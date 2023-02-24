class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& nums) {
      
        int size = nums.size();
   
          vector<map<     long long,     long long>>diff(size);
            long long totalSub = 0;
        
        for(int i=0;i<size;i++){
            
            for(int j=0;j<i;j++){
                    long long difference = (            long long )nums[i]- (            long long )nums[j];
          
                    totalSub+=diff[j][difference];
                  
                diff[i][difference]+=diff[j][difference]+1;
                
            }
        }
        return totalSub;
    }
};