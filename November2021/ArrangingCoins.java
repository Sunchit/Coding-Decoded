class Solution {
	public int arrangeCoins(int n) {
		int rowCount = 0;

		while(n>0){
			rowCount++;
			n = n - rowCount;
		}
		return n==0 ? rowCount : rowCount-1;
	}
}