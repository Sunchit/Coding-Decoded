
//Author : Shobhit Behl (LC:shobhitbruh)
class Solution {
    public int removeCoveredIntervals(int[][] arr) {
        Arrays.sort(arr, (a, b) -> a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        int ans=0;
        int j=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i][1]>j){
                j=arr[i][1];
            }else{
                ans++;
            }
        }

        return arr.length-ans;

    }

class Solution {
	// Tc: O(nlogn)
	// Sc : O(1)
	public int removeCoveredIntervals(int[][] intervals) {
		Arrays.sort(intervals, (a,b) -> (a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]));

		int removalCount=0;
		// Y coordinate
		int prevRange = -1;

		for(int[] interval : intervals){
			if(prevRange>= interval[1]){
				removalCount++;
			}
			prevRange = Math.max(interval[1], prevRange);

		}

		return intervals.length - removalCount;
	}

}