// @saorav21994

class Solution {
    public boolean isUgly(int n) {

        if (n == 0)
            return false;
        
        while (true) {
            while (n%2 == 0)
                n /= 2;
            while (n%3 == 0)
                n /= 3;
            while (n%5 == 0)
                n /= 5;
            break;
        }        

        if (n != 1)
            return false;
        return true;

    }
}
