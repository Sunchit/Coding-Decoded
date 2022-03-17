class Solution {
public:
    int scoreOfParentheses(string s) {
        stack<int> stack;
        int temp=0;
        for(auto& i:s)
        {
            if(i=='(')
                stack.push(0);
            else
            {
                temp=0;
                while(stack.top()!=0)
                {
                    temp+=stack.top();
                    stack.pop();
                }
                stack.pop();
                if(temp==0) stack.push(1);
                else stack.push(2*temp);
            }
        }
        temp=0;
        while(stack.size())
        {
            temp+=stack.top();
            stack.pop();
        }
        return temp;
    }
};