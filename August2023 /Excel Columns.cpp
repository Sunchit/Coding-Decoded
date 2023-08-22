class Solution {
public:
    string convertToTitle(int col) {
        string res="";
        while(col)
        {
            int curr=col%26;
            curr= !curr?26:curr;
            res=string(1,(char)('@'+curr))+res;
            col-=curr;
            col/=26;
        }
        // reverse(begin(res),end(res));
        return res;
    }
};