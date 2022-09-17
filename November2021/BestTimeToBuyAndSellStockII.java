class Solution {

	// TC : O(n)
	// SC : O(1)
	public int maxProfit(int[] prices) {
		int i = 0;
		int buy =0;
		int sell = 0;
		int profit = 0;
		int n = prices.length - 1;
		while (i < n) {
			// till the time prices are decreasing
			while (i < n && prices[i + 1] <= prices[i])  {
				i++;
			}
			// found the buying price
			buy = prices[i];
			//  System.out.print(" Buy " + buy);
			// till the time prices are increasing
			while (i < n && prices[i + 1] > prices[i]) {
				i++;
			}

			// found the selling price
			sell = prices[i];


			// System.out.print(" Sell " + sell);

			profit += sell - buy;
		}
		return profit;
	}
}