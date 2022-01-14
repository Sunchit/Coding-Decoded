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
<<<<<<< HEAD
=======
        }
        return res;
    
    }
};

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
>>>>>>> 66a4075936022a9716743a295c621e2d37041b34
        }
        return res;
    
    }
};