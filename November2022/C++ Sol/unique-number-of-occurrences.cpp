class Solution {
public:
    bool uniqueOccurrences(vector<int>& arr) {
         unordered_map<int,int>freq;
        unordered_map<int,int>m;
        int len = arr.size();
        
        for(int i=0;i<len;i++){
            freq[arr[i]]++;
        
        }
      
        for(auto num:freq){
            
            m[num.second]++;
              
            if(m[num.second]>1){
        
                return false;
            }
        }
        
        
        return true;
        
        
    }
};