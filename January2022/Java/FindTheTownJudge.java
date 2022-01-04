
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

//C++ CODE

class Solution {
public:
    int findJudge(int n, vector<vector<int>>& trust) {
        vector<int>in(n+1,0);
        for(int i=0;i<trust.size();i++){
            in[trust[i][1]]++;
            in[trust[i][0]]--;
        }
        int ans = -1;
        for(int i=1;i<n+1;i++){
            if(in[i] == n-1){
                ans = i;
            }
        }
        return ans;
    }
};
