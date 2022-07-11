// https://leetcode.com/problems/sqrtx/
// @author: anuj0503
class Solution {
    public int mySqrt(int x) {
        if(x == 0 || x == 1)
            return x;
        
        long low = 1, high = x;
        
        while(low < high){
            long mid = low + (high - low)/2;
            
            if(mid*mid > x){
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        
        return (int)(low -1);
    }
}
