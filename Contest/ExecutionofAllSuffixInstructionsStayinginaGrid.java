class Solution {

	// TC : O(S.LENGTH()2)
	// SC : O(S.LENGTH)
	public int[] executeInstructions(int n, int[] startPos, String s) {
		int[] ans = new int[s.length()];

		for(int i=0;i<s.length();i++){
			int countMoves = 0;
			int xIndex = startPos[0];
			int yIndex = startPos[1];
			//System.out.println("Starting Iteration for i" + i);
			for(int j=i;j<s.length();j++){
				if(s.charAt(j) == 'U'){
					xIndex--;
				}
				if(s.charAt(j) == 'D'){
					xIndex++;
				}

				if(s.charAt(j) == 'L'){
					yIndex--;
				}


				if(s.charAt(j) == 'R'){
					yIndex++;
				}


				if(xIndex <0 || yIndex <0 || xIndex >=n || yIndex>=n){
					break;
				} else {
					countMoves++;
				}
			}
			ans[i] = countMoves;
		}
		return ans;
	}
}