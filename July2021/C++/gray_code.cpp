class Solution {
public:
    void bitflip(bitset<16>& val,vector<int>& res,int k)
    {
        if(k==0)
        {
            // cout<<val<<endl;
            res.push_back(val.to_ulong());
        }
        else
        {
            bitflip(val,res,k-1);
            val.flip(k-1);
            bitflip(val,res,k-1);
        }
    }
    vector<int> grayCode(int n) {
        bitset<16> val;
        vector<int> res;
        bitflip(val,res,n);
        return res;
    }
};