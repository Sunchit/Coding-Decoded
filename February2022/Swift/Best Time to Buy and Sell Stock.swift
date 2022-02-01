// Author: Deepal
// Problem: Best Time to Buy and Sell Stock
// Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
// Category: Easy
// DataStructure: Array

func maxProfit(_ prices: [Int]) -> Int {
    guard !prices.isEmpty else { return 0 }
    var sellingPrice = 0
    var maxProfit = 0
    
    for index in stride(from: prices.count - 1, to: -1, by: -1) {
        sellingPrice = max(sellingPrice, prices[index])
        maxProfit = max(maxProfit, sellingPrice - prices[index])
    }
    return maxProfit
}

// TC: O(N)
// SC: O(1)

/*
 
 Example 1:
 Input: prices = [7,1,5,3,6,4]
 Output: 5
 Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 
 Example 2:
 Input: prices = [7,6,4,3,1]
 Output: 0
 Explanation: In this case, no transactions are done and the max profit = 0.
 
 */
