# Author :  Karthik K (https://www.linkedin.com/in/karthikmunirathinam/)

# TC : O(N)
# SC : O(1)

class Solution:
    def canPlaceFlowers(self, flowerbed: List[int], n: int) -> bool:
        ind = 0
        while ind < len(flowerbed):
            if flowerbed[ind] == 0 and (ind == 0 or flowerbed[ind-1] == 0) and (ind == len(flowerbed)-1 or flowerbed[ind+1] == 0):
                n -= 1
                flowerbed[ind] = 1
                ind += 1
            if n <= 0:
                return True
            ind += 1
        return False
