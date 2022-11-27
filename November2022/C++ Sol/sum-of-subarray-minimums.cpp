class Solution {
public:
    int sumSubarrayMins(vector<int>& arr) {
    
        
        long long len = arr.size();
        long long ans = 0;
        long long mod = 1e9 + 7;
        
        vector<long long>left(len);
        vector<long long>right(len);
        stack<long long>st;
        
        for(int i=0;i<len;i++){
            
            while(!st.empty() && arr[st.top()]>arr[i]){
                st.pop();
            }
            
            
            if(st.empty()){
                 left[i] = i+1;
            }
            else{
            left[i] = i-st.top();
            }
            
            
            st.push(i);
        }
        
        while(!st.empty()){
            st.pop();
        }
        
         for(int i=0;i<len;i++){
             
            while(!st.empty() && arr[st.top()]>arr[i]){
                  right[st.top()] = i-st.top();
                st.pop();
            }
           
             
            st.push(i);
        }
        
        while(!st.empty()){
            
            right[st.top()] = len - st.top();
            st.pop();
        }
        
        for(long long i=0;i<len;i++){
         
            ans = ((ans%mod) + (left[i]*right[i]*arr[i]%mod))%mod;
        }
        
       
        return ans;
    }
};