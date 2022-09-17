// https://leetcode.com/problems/count-special-integers/
// @author: anuj0503
class Solution {
    public int countSpecialNumbers(int n) {
        if(n <= 10) return n;

        // Storing number in arraylist
        int temp = n, result = 0;
        ArrayList<Integer> num = new ArrayList<>();
        while (temp != 0){
            num.add(temp%10);
            temp /= 10;
        }

        // Storing number in proper form.
        Collections.reverse(num);

        // Suppose size is m, then calculating all numbers having distinct digits
        // and length m-1, m-2,....1. This is easy to drive just use pen and paper
        // and try to make such numbers of length n.
        for(int len = num.size() - 1; len > 0; len--){
            result += getCount(len);
        }

        // Using dfs where, we will fix a number at an position
        // (like thousand position, a hundred position, ten position and so on)
        // And keep calculating the number by fixing them.
        // mask is use to store which all numbers are previously fixed in dfs.
        result += dfs(0, 0, num);
        return result;
    }

    private int getCount(int n){
        return 9 * getCountForLengthN(n - 1, 9);
    }

    private int getCountForLengthN(int n, int mul){
        if(n == 0 || mul == 0) return 1;

        return mul * getCountForLengthN(n - 1, mul - 1);
    }

    private int dfs(int index, int mask, ArrayList<Integer> num){
        if(index >= num.size()) return 1;

        int digit = num.get(index);
        int count = 0;
        int ans = 0;

        // for first position of given number (left to right)
        // we dont have 0 as option that why we initalize variable from 1.
        for(int i = ((index == 0)?1:0); i < digit; i++){
            if((mask&(1<<i)) == 0){
                ans += getCountForLengthN(num.size() - index - 1, 9 - index);
            }
        }

        // If number is not previously use, go for further dfs by taking the
        // current digit in mask.
        if((mask & (1 << digit)) == 0) {
            return ans + dfs(index + 1, mask + (1 << digit), num);
        }

        // Otherwise taht number is already used and cant make distinct digit number.
        return ans;
    }
}
