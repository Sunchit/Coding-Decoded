# Author :  Karthik K (https://www.linkedin.com/in/karthikmunirathinam/)

#  Approach 1

class Solution:
    def addBinary(self, a: str, b: str) -> str:
        return bin(int(a, 2)+int(b, 2))[2:]

     #   Approach 2

    def addBinary(self, a: str, b: str) -> str:
        a, b, res, carry = list(a), list(b), "", 0
        while a or b:
            d1 = 0
            d2 = 0
            if a:
                d1 = int(a.pop())
            if b:
                d2 = int(b.pop())
            curr = str((d1+d2+carry) % 2)
            carry = (d1+d2+carry)//2
            res = curr+res
        return "1"+res if carry else res
