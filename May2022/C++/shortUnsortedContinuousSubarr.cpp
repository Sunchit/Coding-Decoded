//Problem Link : https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
class Solution {
public:
    int findUnsortedSubarray(vector<int>& nums) {
        int n = nums.size();
        stack<int> st;
        //for left index
        int l = n - 1;
        for(int i = 0; i < n; ){
          
          if( !st.empty() && nums[st.top()] > nums[i]){
                    l = min(st.top(),l);
                    st.pop();
            }
            else{
                st.push(i);
                i++;
            }
        }
        stack<int> st2;
         //for right index
        int r = 0;
        for(int i = n-1; i >= 0;){
          
          if( !st2.empty() && nums[st2.top()] < nums[i]){
                    r = max(st2.top(),r);
                    st2.pop();
            }
            else{
                st2.push(i);
                i--;
            }
        }
        if(l>=r)
        {
            return 0;
        }
        return r -l + 1;
        
    }
};
