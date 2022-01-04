class Solution {
public:
    int bitwiseComplement(int n) {
        if(n<1) return 1;
        int com=1;
        while(com<=n)
        {
            n^=com;
            com<<=1;
        }
        return n;
        
    }
};


// C++ code
class Solution {
public:
    int bitwiseComplement(int n) {
        if(n==0)return 1;
        int p = 1;
        int ans= 0;
        while(n){
            int bit = n & 1;   //to find the last bit is 0 or 1 
            if(bit==0){
                //because 0 bit will contribute to our answer as we want compliment
                ans+=p;
            }
            p <<= 1;   // p = p*2
            n >>= 1;   // right shifting by 1
        }
        return ans;
    }
};


// Contributed by Ankit Ghosh
