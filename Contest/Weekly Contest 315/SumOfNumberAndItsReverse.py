# https://leetcode.com/problems/sum-of-number-and-its-reverse/
# Java Binary Search Solution from Discuss = https://leetcode.com/problems/sum-of-number-and-its-reverse/solutions/2708324/java-binary-search-solution-o-log-n-beats-100/?q=binary+search&orderBy=most_relevant
# Author : @Jiganesh

class Solution:

    # TC : O(N*M) reversing N Numbers of M digits
    # SC : O(N*M) String Pool
    def sumOfNumberAndReverse(self, num: int) -> bool:
        
        for i in range (num+1):
            if i + int(str(i)[::-1]) == num:
                return True
        return False
            