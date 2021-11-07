// author : shyam2520 
// https://leetcode.com/problems/multiply-strings/
class Solution {
public:
    string multiply(string num1, string num2) {
        int m=num1.size(),n=num2.size();
        vector<int> res(n+m,0);
        for(int i=m-1;i>=0;i--)
        {
            for(int j=n-1;j>=0;j--)
            {
                int mul=(int)(num2[j]-'0')*(int)(num1[i]-'0');
                int sum=mul+res[i+j+1];
                res[i+j+1]=sum%10;
                res[i+j]+=sum/10;
            }
        }
        string ans="";
        int i=0;
        while(i<n+m)
        {
            if(res[i]) 
                break;
            i++;
        }
        
        for(;i<n+m;i++)
            ans+=res[i]+'0';
       
        if(!ans.size())
            return "0";
        return ans;
    }
};