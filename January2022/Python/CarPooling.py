
#Author :  Karthik K (https://www.linkedin.com/in/karthikmunirathinam/)

class Solution:
    #TC : O(n)
    #SC : O(1) 
    
    def carPooling(self, trips: List[List[int]], capacity: int) -> bool:
        occupancy=[0]*1001
        for index in range(len(trips)):
            occupancy[trips[index][1]]+=trips[index][0]
            occupancy[trips[index][2]]-=trips[index][0]
        currCapacity=0
        for currOccupancy in occupancy:
            currCapacity+=currOccupancy
            if currCapacity>capacity:
                return False
        return True
        