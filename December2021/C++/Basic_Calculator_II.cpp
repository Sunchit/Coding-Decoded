class Solution {
public:
    int calculate(string s) {
        stack<int> stack;
        char sign='+';
        int temp=0,num=0,res=0;
        for(int i=0;i<s.length();i++)
        {
            if(isdigit(s[i]))
                temp=temp*10+(s[i]-'0');
            if((!isdigit(s[i]) && !isspace(s[i])) || i==s.length()-1)
            {
                if(sign=='+')
                    stack.push(temp);
                else if(sign=='-')
                    stack.push(-temp);
                else if(sign=='*')
                {
                    num=stack.top()*temp;
                    stack.pop();
                    stack.push(num);
                }
                else
                {
                    num=stack.top()/temp;
                    // cout<<num<<endl;
                    stack.pop();
                    stack.push(num);
                }
                temp=0;
                sign=s[i];
            }
        }
        while(stack.size())
        {
            res+=stack.top(); stack.pop();
        }
        return res;
    }
};