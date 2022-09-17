# Author :  Karthik K (https://www.linkedin.com/in/karthikmunirathinam/)

# TC : O(N)

# SC : O(1)

class Solution:
    def myAtoi(self, s: str) -> int:
        sign = 1
        num = 0
        ind = 0
        INT_MAX = 2**31-1
        INT_MIN = -(2**31)
        while ind < len(s) and s[ind] == ' ':
            ind += 1
        if ind >= len(s):
            return 0
        if s[ind] == '+' or s[ind] == '-':
            sign = 1 if s[ind] == '+' else -1
            ind += 1
        if ind >= len(s):
            return 0
        while ind < len(s) and s[ind].isdigit():
            if num > INT_MAX//10 or (num == INT_MAX//10 and int(s[ind]) > INT_MAX % 10):
                return INT_MAX if sign == 1 else INT_MIN
            num = num*10+int(s[ind])
            ind += 1
        return num*sign
