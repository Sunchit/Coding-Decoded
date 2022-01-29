class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        heights.push_back(0);
        stack<pair<int,int>> stack;
        int res=0,idx=0;
        for(int i=0;i<heights.size();i++)
        {
            if(stack.empty()) stack.push({heights[i],i});
            else
            {
                idx=i;
                while(stack.size() && heights[i]<stack.top().first)
                {
                    res=max(res,stack.top().first*(i-stack.top().second));
                    idx=stack.top().second;
                    stack.pop();
                }
                stack.push({heights[i],idx});
            }
        }
        return res;
    }
};