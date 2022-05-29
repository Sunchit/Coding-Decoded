
// @saorav21994
// TC : O(logn)
// SC : O(1)

class Solution {
    public int numberOfSteps(int num) {
        int cnt = 0;
        while (num != 0) {
            if (num%2 == 0)
                num /= 2;
            else
                num -= 1;
            cnt += 1;
        }    
        return cnt;
    }
}
