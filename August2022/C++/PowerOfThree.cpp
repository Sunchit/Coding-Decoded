class Solution {
public:
    // TC: O(log3(n))
    // SC: O(1)
    bool isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }
        while (n > 1) {
            int remainder = n % 3;
            if (remainder != 0) {
                return false;
            }
            n /= 3;
        }
        return true;
    }
};
