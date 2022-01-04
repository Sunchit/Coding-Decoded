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