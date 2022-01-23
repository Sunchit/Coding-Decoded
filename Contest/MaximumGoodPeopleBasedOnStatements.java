class Solution {

	public int maximumGood(int[][] statements) {
		int n= statements.length;
		int maxGoodPersons= 0;
		int combos = 1<<n;

		int[] roles= new int[n];
		// iterate through all combinations of good/bad people using bit masks
		for(int mask=1; mask<combos; mask++){
			int currentGoodPersons= apply(roles, mask);
			// [0 1 1]
			if(valid(statements, roles))
				maxGoodPersons= Math.max(maxGoodPersons, currentGoodPersons);
		}
		return maxGoodPersons;
	}

	// convert bitmask to role array, count good people in this mask
	private int apply(int[] roles, int mask){
		// 3 -> 0 1 1
		int count= 0;
		int n = roles.length;
		for(int i=0; i<n; i++){
			count+= roles[i]= mask&1;
			mask>>=1;
		}
		return count;
	}

	private boolean valid(int[][] statements, int[] roles){
		int n= statements.length;
		for(int i=0; i<n; i++){
			// Ignore bad people
			if(roles[i]==0) continue;
			// only check statements of good people

			for(int j=0; j<n; j++){
				if(statements[i][j]==2) continue;
				// statement of a good person contradicts the assigned role in this combination
				if(statements[i][j]!=roles[j]) return false;
			}
		}
		return true;
	}
}