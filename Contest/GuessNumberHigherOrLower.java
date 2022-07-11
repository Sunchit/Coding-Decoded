// https://leetcode.com/problems/guess-number-higher-or-lower/
// @author: anuj0503
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 1, high = n;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            
            int g = guess(mid);
            
            if(g == 0)
                return mid;
            
            if(g == -1){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return 0;
    }
}
