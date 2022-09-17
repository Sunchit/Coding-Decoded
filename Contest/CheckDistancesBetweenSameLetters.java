class Solution {
	// TC : O(n)
	// SC : O(1)
	public boolean checkDistances(String s, int[] distance) {
		int[][] indicesList = new int[26][2];

		for(int[] indices : indicesList) {
			Arrays.fill(indices, -1);
		}

		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			int[] indices = indicesList[c-'a'];
			if(indices[0] == -1){
				indices[0] = i;
			} else {
				indices[1] = i;
			}
		}

		for(int i=0;i<distance.length;i++){
			if(indicesList[i][0]!=-1 && indicesList[i][1]!=-1 ){
				int actualDistance = indicesList[i][1] - indicesList[i][0] -1;
				if(actualDistance!=distance[i]){
					return false;
				}
			}
		}
		return true;
	}
}