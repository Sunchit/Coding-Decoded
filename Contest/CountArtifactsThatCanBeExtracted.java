class Solution {
	public int digArtifacts(int n, int[][] artifacts, int[][] dig) {

		boolean uncovered[][] = new boolean[n][n];
		for(int digged[]:dig){
			uncovered[digged[0]][digged[1]]=true;
		}

		int count=0;
		for(int artifact[]:artifacts){

			boolean flag=true;

			for(int i=artifact[0];i<=artifact[2];i++){
				for(int j=artifact[1];j<=artifact[3];j++){
					if(!uncovered[i][j])  {
						flag=false;
						break;
					}
				}
			}
			if(flag) count++;
		}
		return count;
	}
}