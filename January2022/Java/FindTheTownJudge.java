
class Solution {
	// TC : O(n)
	// SC : O(n)
	public int findJudge(int N, int[][] trust) {

		int[] inwardDegree = new int[N+1];
		int[] outwardDegree = new int[N+1];
		for(int i=0;i<trust.length;i++){
			int countOut = outwardDegree[trust[i][0]];
			outwardDegree[trust[i][0]] =  countOut+1;
			int countIn = inwardDegree[trust[i][1]];
			inwardDegree[trust[i][1]]=  countIn+1;
		}
		for(int i=1;i<=N;i++){
			if(outwardDegree[i]==0&& inwardDegree[i]==N-1){
				return i; // town judge
			}
		}
		return -1;
	}
}