
class Solution {
	/*
	public int minimumLines(int[][] stockPrices) {

			Arrays.sort(stockPrices, (a,b) -> (a[0] - b[0]));
			double prevSlope = Double.MAX_VALUE;
			int count = 0;
			for(int i=1;i<stockPrices.length;i++) {
					double currentSlope = ((double)(stockPrices[i][0] - stockPrices[i-1][0])/(double)(stockPrices[i][1] - stockPrices[i-1][1]));


							//System.out.println(currentSlope + " " + prevSlope);
					if(currentSlope == prevSlope){
							continue;
					} else {

							count++;
							prevSlope =  currentSlope;
					}
			}
			return count;
	}
 */
	// TC : O(nlogn)
	// SC : O(1)
	public int minimumLines(int[][] stockPrices) {

		if (stockPrices.length == 1) return 0;

		Arrays.sort(stockPrices, (a,b) -> (a[0] - b[0]));

		int count = 1;
		for (int i = 2; i < stockPrices.length; i++) {
			// A(x0,y0) , B(x1,y1), C(x2,y2)
			// (y2 - y1) / (x2 - x1) == (y1 - y0) / (x1 - x0)
			// => (y2 - y1) * (x1 - x0) == (y1 - y0) * (x2 - x1)
			if ((stockPrices[i][1] - stockPrices[i - 1][1]) * (stockPrices[i - 1][0] - stockPrices[i - 2][0]) !=
							(stockPrices[i - 1][1] - stockPrices[i - 2][1]) * (stockPrices[i][0] - stockPrices[i - 1][0])) {
				count += 1;

			}


		}

		return count;
	}

}