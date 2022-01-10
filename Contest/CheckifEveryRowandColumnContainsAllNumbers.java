class Solution {

	// TC : O(n2)
	//SC : O(n)
	public boolean checkValid(int[][] matrix) {
		Set<Integer> set = null;

		for(int i = 0;i<matrix.length;i++){
			set = new HashSet<>();
			for(int j=0;j<matrix[0].length;j++){


				int el = matrix[i][j];
				if(set.contains(el)){
					return false;
				} else{
					set.add(el);
				}
			}
		}


		for(int i = 0;i<matrix[0].length;i++){
			set = new HashSet<>();
			for(int j=0;j<matrix.length;j++){


				int el = matrix[j][i];
				if(set.contains(el)){
					return false;
				} else{
					set.add(el);
				}
			}
		}

		return true;
	}
}


class Solution {

	// TC : O(n2)
	//SC : O(1)

	public boolean checkValid(int[][] matrix) {
		int n = matrix.length;

		for (int i = 0; i < n; i++) {
			int rowXor = 0;
			int colXor = 0;
			for (int j = 0; j < n; j++) {

				rowXor ^= matrix[i][j] ^ (j + 1);
				colXor ^= matrix[j][i] ^ (j + 1);
			}
			if (rowXor != 0 || colXor != 0)
				return false;
		}
		return true;

	}
}