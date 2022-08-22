class Solution {
public:
    // TC: O(logn)
    // SC: O(logn)
    bool isPowerOfFour(int n) {
        if (n == 1) {
            return true;
        }
        if (n % 4 == 0 && n != 0) {
            return isPowerOfFour(n / 4);
        } else {
            return false;
        }
    }
};
