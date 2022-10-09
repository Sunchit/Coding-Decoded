# https://leetcode.com/problems/find-the-original-array-of-prefix-xor/
# author : @Jiganesh

from typing import List

class Solution:
    def findArray(self, pref: List[int]) -> List[int]:

        result = [pref[0]]

        for i in range(1, len(pref)):
            result.append(pref[i-1] ^ pref[i])

        return result


'''

Input: pref = [5,2,0,3,1]
Output: [5,7,2,3,2]
Explanation: From the array [5,7,2,3,2] we have the following:
- pref[0] = 5.
- pref[1] = 5 ^ 7 = 2.
- pref[2] = 5 ^ 7 ^ 2 = 0.
- pref[3] = 5 ^ 7 ^ 2 ^ 3 = 3.
- pref[4] = 5 ^ 7 ^ 2 ^ 3 ^ 2 = 1.

5
5 ^ 7 = 2.
5 ^ 7 ^ 2 = 0.
5 ^ 7 ^ 2 ^ 3 = 3.
5 ^ 7 ^ 2 ^ 3 ^ 2 = 1.

for index = 0
0 ^ 5 = 0 ^ 5
hence original_array[0] = 5

for index = 1
(5) ^ (5 ^ x) = 2
5 ^ 2 = x
x = 7
hence original_array[1] = 7


for index = 2
(5 ^ 7)  ^ (5 ^ 7 ^ x) =  0
5 ^ 7 ^ x = 0
2 ^ 0 = x
hence original_array[2] = 2^0 = 2

for index = 3
5 ^ 7 ^ 2 ^ x = 3
(5 ^ 7 ^ 2) ^ x = 3
0 ^ x = 3
x = 3
hence original_array[3] = 3

and so on ------------------------

'''
