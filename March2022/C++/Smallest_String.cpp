class Solution {
public:
    string getSmallestString(int n, int k) {
        string res="";
        for(int i=0;i<n;i++) res+='a';
        int curr=n;
        int idx=n-1;
        k-=n;
        while(idx>=0 && k>0)
        {
            if(k>=26)
            {
                res[idx]='z';
                k=(k+1)-26;
            }
            else
            {
                res[idx]=(char)(k+'a');
                break;
            }
            idx--;
        }
        return res;
    }
};