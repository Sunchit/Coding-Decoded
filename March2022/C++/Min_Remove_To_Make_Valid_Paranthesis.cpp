class Solution {
public:
    string minRemoveToMakeValid(string s) {
        stack<int> stack;
        for(int i=0;i<s.length();i++)
        {
            if(s[i]=='(') stack.push(i);
            else if(s[i]==')') 
            {
                if(stack.size() && s[stack.top()]=='(') stack.pop();
                else stack.push(i);
            }
        }
        int start=0;
        
        while(stack.size())
        {
            s[stack.top()]=' ';
            stack.pop();
        }
        string res="";
        stringstream ss(s);
        string temp;
        while(ss>>temp) res+=temp;

        
        return res;
    }
};