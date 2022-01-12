class Solution {
public:
    string addBinary(string a, string b) {
        int al=a.size(),bl=b.size();
        if(al<bl)
            return addBinary(b,a);
        int prev=0;
        string ans;
        for(int i=al-1;i>=0;i--){
            int a1 = a[i]-'0';
            int b1 = (i>=al-bl)?(b[i-al+bl]-'0'):0;
            int temp = (prev + a1 + b1)%2;
            prev = (prev + a1 + b1)/2;
            ans+=(temp+'0');
        }
        if(prev)
            ans+='1';
        return string(ans.rbegin(),ans.rend());
    }
};
