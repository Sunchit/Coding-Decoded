class Solution {
	public int countLatticePoints(int[][] circles) {
		Set<int[]> set = new HashSet<>();

		for(int[] circle : circles){

			int x = circle[0];
			int y = circle[1];
			int r = circle[2];

			for(int i = x - r; i <= x + r; i++){
				for(int j = y - r; j <= y + r; j++){

					if((i - x) * (i - x) + (j - y) * (j - y) <= r * r){
						set.add(new int[]{i, j});
					}
				}
			}
		}

		return set.size();
	}
}