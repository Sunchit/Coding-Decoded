class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        
        stack<pair<int,int>>temp;
        
  
        int len = temperatures.size();
        
        vector<int>ans(len,0);
        
        
        for(int index = len-1; index>=0; index--){
            
            int currTemp = temperatures[index];
            
            while(!temp.empty() && temp.top().first<= currTemp){
                
                temp.pop();
                
            }
            
            if(temp.size()){
                
                ans[index] = temp.top().second - index;
            }
            
            temp.push({currTemp, index});
        }
        
        return ans;
    }
};