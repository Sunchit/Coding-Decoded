class Solution {
public:
    int myAtoi(string s) {
        // return 0;
        long double res=0;
        bool sign=false,setres=false;
        int val=1,i=0;
        
        while(i<s.length() && isspace(s[i])) i++;
        if(!(isdigit(s[i]) ||( (s[i]=='+' || s[i]=='-' )&& isdigit(s[i+1])))) return 0;
        
        while(i<s.length() && (isdigit(s[i]) || !setres))
        {
            if((s[i]=='-' || s[i]=='+') && !sign)
            {
                sign =true;
                val=(s[i]=='-')?-1 : 1;
            }
            if(isdigit(s[i]))
            {
                setres=true;
                res=res*10+(s[i]-'0');
            }
            i++;
        }
        res= val * res;
        return res<INT_MIN?INT_MIN:res>INT_MAX?INT_MAX:(int)res;
    }
};