class Solution:
    def successfulPairs(self, spells: List[int], potions: List[int], success: int) -> List[int]:
        n = len(spells)
        m = len(potions)
        potions.sort()
        
        for i in range(n):
            start = 0
            end = m - 1
            ind = -1
            
            while start <= end:
                mid = start + (end - start) // 2
                product = spells[i] * potions[mid]
                
                if product >= success:
                    ind = mid
                    end = mid - 1
                else:
                    start = mid + 1
                    
            spells[i] = m - ind if ind != -1 else 0
        
        return spells
        
