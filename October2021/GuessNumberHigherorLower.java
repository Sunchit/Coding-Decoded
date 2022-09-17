/**
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 1;
        int high = n;

        while(low<=high){
            int mid = low + (high-low)/2;
            int res = guess(mid);
            if(res == 0){
                return mid;
            }
            else if(res==-1){
                //System.out.println("Reducing high node");
                high = mid-1;

            } else {
                // System.out.println("Increasing lower bound");
                low = mid +1;
            }
        }
        return -1;
    }
}