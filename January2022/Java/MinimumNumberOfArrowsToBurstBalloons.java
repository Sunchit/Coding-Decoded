
class Solution {
	// TC : O(nlogn)
	// SC : O(1)
	public int findMinArrowShots(int[][] points) {
		Arrays.sort(points,(a,b) -> Integer.compare(a[1], b[1]));
		// sorting on the basis of end points

		int arrow = 1;
		int reach = points[0][1];
		for(int i=1;i<points.length;i++){
			if(points[i][0] > reach){
				// if start point is greater than the end then there is no common area
				// so we need another arrow to burst this ballon
				arrow++;
				reach = points[i][1];
			} else{
				// reach is beyond or equal to this new entry
				// skip the current element
			}
		}
		return arrow;
	}
}