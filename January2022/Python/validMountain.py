# Author :  Karthik K (https://www.linkedin.com/in/karthikmunirathinam/)

# TC : O(N)
# SC : O(1)

class Solution:
    def validMountainArray(self, arr: List[int]) -> bool:
        ind = 0
        l = len(arr)
        while ind+1 < l and arr[ind] < arr[ind+1]:
            ind += 1
        if ind == 0 or ind == l-1:
            return False
        while ind+1 < l and arr[ind] > arr[ind+1]:
            ind += 1
        return ind == l-1
