// https://leetcode.com/problems/minimum-operations-to-make-array-equal/
// @author: anuj0503
class Solution {
    public int minOperations(int n) {
        int result = 0;
        int mid = 0;
        if(n%2 == 0){
            int mid1 = 2*(n/2) + 1;
            int mid2 = 2*(n/2 - 1) + 1;
            
            mid = (mid1 + mid2)/2;
        } else {
            mid = 2*(n/2) + 1;
        }
        
        for(int i = 0; i < n/2; i++) result += Math.abs(2*i + 1 - mid);
        
        return result;
    }
}
