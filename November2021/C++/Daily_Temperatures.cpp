class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temp) {
        vector<int> stack(temp.size(),0);
        vector<int> res(temp.size(),0);
        int top=-1;
        for(int i=0;i<temp.size();i++)
        {
            while(top>-1 && temp[i]>temp[stack[top]])
            {
                int idx=stack[top--];
                res[idx]=i-idx;
            }
            stack[++top]=i;
        }
        return res;
    }
};