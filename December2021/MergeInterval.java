class Solution {
	// TC : O(nlogn)
	public int[][] merge(int[][] intervals) {
		// O(nlogn)
		Arrays.sort(intervals, (a,b) -> (a[0] - b[0]));
		Stack<int[]> st = new Stack<>();
		// O(n)
		for(int i=0;i<intervals.length;i++){
			int[] currInt = intervals[i];
			if(!st.isEmpty()){
				int[] top = st.peek();
				if(top[1]>=currInt[0]){
					// Successful overlap
					st.pop();
					int minStart = top[0];
					int maxEnd = Math.max(top[1],currInt[1]);
					st.push(new int[]{minStart, maxEnd});
				} else{
					// no overlap
					st.push(currInt);
				}
			} else{
				st.push(currInt);
			}

		}

		int[][] res = new int[st.size()][2];
		int count = st.size()-1;
		while(!st.empty()){
			int[] top = st.pop();
			res[count][0] = top[0];
			res[count][1] = top[1];
			count--;
		}
		return res;

	}
}