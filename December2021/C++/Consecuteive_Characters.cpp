class Solution {
public:
    int maxPower(string s) {
        int temp=1,res=0;
        for(int i=1;i<s.length();i++)
        {
            if(s[i]==s[i-1]) temp++;
            else
            {
                res=max(res,temp);
                temp=1;
            }
        }
        return max(temp,res);
    }
};