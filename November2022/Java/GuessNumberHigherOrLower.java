// @saorav21994

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
        // Algorithm -> Binary search
        int l = 0, h = n;
        int mid = l + (h-l) / 2;
        while (l <= h) {
            // System.out.println("l = " + l + " h = " + h);
            int g = guess(mid);
            if (g == 0)
                return mid;
            else if (g < 0)
                h = mid - 1;
            else 
                l = mid + 1;
            mid = l + (h-l)/2;
        }
        return l;
    }
}
