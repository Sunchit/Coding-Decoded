// Author: Mahesh Reddy B N

// Problem Link: https://leetcode.com/problems/add-digits/description/

class Solution {
    public int addDigits(int num) {
        while(num>=10){
            int x = 0;
            while(num>0){
                x+= num%10;
                num = num/10;
            }
            num = x;
        }
        return num;
    }
}   