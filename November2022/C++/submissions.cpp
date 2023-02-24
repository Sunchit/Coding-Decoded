class Solution {
public:
    bool isUgly(int n) {
        
        if(n == 0){
            return false;
        }
        
        for(int k =2; k <= 5; k++){
            while(n%k==0){
                n = n/k;
            }
        }
        
        return n==1;
    }
};