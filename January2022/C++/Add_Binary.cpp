class Solution {
public:
    string addBinary(string a, string b) {
        string res="";
        int c=0,i=a.length()-1,j=b.length()-1;
        while(c || i>=0 || j>=0)
        {
            c+= i>=0? a[i--]-'0':0;
            c+= j>=0? b[j--]-'0':0;
            res=char(c%2 +'0')+res;  
            c/=2;
        }
        return res;
    
    }
};