// https://leetcode.com/problems/first-bad-version/
// @author: anuj0503
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        long low = 0, high = n;
        
        while(low < high){
            long mid = low + (high - low)/2;
            boolean v = isBadVersion((int)mid);
            
            if(!v){
                low = mid + 1;
            } else{
                high = mid;
            }
        }
        
        return (int)low;
    }
}
