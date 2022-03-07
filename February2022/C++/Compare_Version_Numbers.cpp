class Solution {
public:
    int compareVersion(string v1, string v2) {
        int res=0,temp0=0,temp1=0,i=0,j=0;
        for(;(i<v1.length() || j<v2.length()) && !res;i++,j++)
        {
            temp0=0;temp1=0;
            while(i<v1.length() && v1[i]!='.') temp0=temp0*10 + v1[i++]-'0';
            while(j<v2.length() && v2[j]!='.') temp1=temp1*10 + v2[j++]-'0';
            if(temp0<temp1) res=-1;
            else if(temp1<temp0) res=1;
            
        }
        return res;
    }
};