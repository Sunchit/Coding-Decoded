public class Solution {
	// TC: O(n)
	// SC : O(1)
	public boolean canPlaceFlowers(int[] flowerbed, int n) {

		for(int i = 0; i < flowerbed.length && n>0;  i++) {
			if(flowerbed[i] == 0) {
				int next = (i == flowerbed.length - 1) ? 0 : flowerbed[i + 1];
				int prev = (i == 0) ? 0 : flowerbed[i - 1];
				if(next == 0 && prev == 0) {
					flowerbed[i] = 1;
					n--;
				}
			}
		}

		return  n==0;
	}
}