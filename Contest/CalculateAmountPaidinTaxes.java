class Solution {
	// TC : o(n)
	// SC  : O(1)
	public double calculateTax(int[][] brackets, int income) {
		int previousEarning = 0;
		int i=0;
		double tax = 0.0D;
		while(i<brackets.length){
			int earning = Math.min(brackets[i][0], income) - previousEarning;

			tax += earning* brackets[i][1]/100.0d;

			previousEarning = brackets[i][0];
			if (brackets[i][0] >= income) break;
			i++;
		}

		return tax;

	}

}