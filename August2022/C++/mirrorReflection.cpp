class Solution {
public:
    int mirrorReflection(int p, int q) {
        
        while(p%2==0 and q%2==0) 
        {
            p>>=1;
            q>>=1;
        }
        if(p%2==0 and q%2==1) return 2;
        else if(p%2==1 and q%2==1) return 1;
        return 0;
        
    }
};
