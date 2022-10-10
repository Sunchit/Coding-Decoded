# https://leetcode.com/problems/break-a-palindrome/
# Author : @Jiganesh

class Solution:
    
    # TC : O(N)
    # SC : O(N)
    def breakPalindrome(self, palindrome: str) -> str:

        palindrome = list(palindrome)
        
        n = len(palindrome)
        mid = n //2

        if n < 2: return ""

        for i in range (mid):
            if palindrome[i]!= "a":
                palindrome[i]="a"
                return "".join(palindrome)

        palindrome[-1]="b"
        return "".join(palindrome)                

