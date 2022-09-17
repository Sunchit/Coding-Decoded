// author : shyam2520 
//https://leetcode.com/problems/arranging-coins/
class Solution {
public:
    int arrangeCoins(int n) {
        int i=1;
        while(n>=i)
        {
            n-=i;
            i++;
        }
        return i-1;
    }
};

/*
Alternate Solution : https://leetcode.com/problems/arranging-coins/discuss/92365/C%2B%2B-1-line-code
class Solution {
public:
    int arrangeCoins(int n) {
       return floor((sqrt((double)2*n + 0.25)-0.5));
    }
};
*/