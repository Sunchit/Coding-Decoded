
// @saorav21995
// Easy


class Solution {
    public int addDigits(int num) {
        int res = 0;
        while (true) {
            int d = num%10;
            res += d;
            num /= 10;
            if (num == 0) {
                if (res/10 == 0)
                    break;
                num = res;
                res = 0;
            }
        }
        return res;
    }
}
