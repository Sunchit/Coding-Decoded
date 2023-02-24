/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

class Solution {
public:
    int guessNumber(int n) {
        int low = 1;
        int high = n;
        while(low<=high){
            int mid = low +(high-low)/2;
            int currNum = guess(mid);
            if(currNum==0){
                return mid;
            }
            else if(currNum==-1){
                high = mid -1;
            }
            else{
                low = mid + 1;
            }
        }
        
        
        return n;
    }
};