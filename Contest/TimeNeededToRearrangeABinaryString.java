// https://leetcode.com/problems/time-needed-to-rearrange-a-binary-string/
// @author: @anuj0503
class Solution {
    public int secondsToRemoveOccurrences(String s) {
        int zCount = 0;
        int n = s.length();

        if(n == 1) return 0;

        for (int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0') zCount++;
        }

        int result = 0;
        while(lastZeroes(s, n) != zCount){
            s = s.replaceAll("01", "10");
            result++;
        }

        return result;
    }

    private int lastZeroes(String s, int n){
        int c = 0;
        while(n >= 1){
            if(s.charAt(n - 1) == '0'){
                c++; n--;
            }
            else return c;
        }

        return c;
    }
}
