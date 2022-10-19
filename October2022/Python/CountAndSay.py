# https://leetcode.com/problems/count-and-say/
# Author : Jiganesh

class Solution:
    
    # TC : O(N^2) # 30N 
    # SC :O(N)
    def countAndSay(self, n: int) -> str:

        def helper(string):
            ch = string[0]
            count = 0

            result = ""
            for i in string:
                if ch == i:
                    count+=1
                else:
                    result+= str(count) + ch
                    ch = i
                    count=1
            result+= str(count) + ch
            return result

        string = "1"

        if n == 1:
            return "1"
            
        while n>1:
            print(string)
            string = helper(string)
            n-=1
        return string
