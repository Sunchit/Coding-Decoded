class Solution {
    int gcd(int a,int b)
    {
        if(a==0) return b;
        return gcd(b%a,a);
    }
public:
    int nthMagicalNumber(int n, int a, int b) {
        long long  l=min(a,b);
        long long  r= l*n;
        long long lcm=(a*b)/gcd(a,b);
        long long mid,factor;
        while(l<r)
        {
            mid=l+(r-l)/2;
            factor=mid/a +mid/b - mid/lcm;
            if(factor<n) l=mid+1;
            else r=mid;
        }
        int mod=1e9+7;
        return l%mod;
    }
};