class Solution {
public:
    int minMoves(int target, int maxDoubles) {
        int ans=0;
        while(target>1){
            if(target%2){
                target--;
                ans++;
            }else{
                if(maxDoubles){
                    target/=2;
                    ans++;
                    maxDoubles--;                    
                }else{
                    return ans+target-1;
                    target--;
                    ans++;
                }
            }
        }
        return ans;
    }
};
