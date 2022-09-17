# TC : O(N)
#SC : O(1)

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        minToDate = prices[0]
        profit = 0
        for day in range(len(prices)):
            if prices[day] < minToDate:
                minToDate = prices[day]
            else:
                profit = max(profit, prices[day]-minToDate)
        return profit
