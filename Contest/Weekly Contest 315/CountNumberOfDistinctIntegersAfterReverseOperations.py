# https://leetcode.com/problems/count-number-of-distinct-integers-after-reverse-operations/
# Author : @Jiganesh

from typing import List

class Solution:
    
    # TC : O(N*M) where N is the length of nums and M is the length of operations
    # SC : O(N)
    def countDistinctIntegers(self, nums: List[int]) -> int:
        
        def reversed_num(number):
            rev_num = 0
            while number:
                rev_num = rev_num*10 + number%10
                number//=10
            return rev_num
        
        lookup = set()
        
        for number in nums:
            lookup.add(number)
            lookup.add(reversed_num(number))
            
        return len(lookup)