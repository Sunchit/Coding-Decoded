// https://leetcode.com/problems/meeting-rooms/
// @author: anuj0503
public class Solution{
    public boolean canAttendMeetings(int[][] intervals){
        if(intervals == null || intervals.length == 1) return true;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int[] prevInterval = intervals[0];
        for(int i = 1; i < intervals.length; i++){
            int[] currInterval = intervals[i];

            if(prevInterval[1] > currInterval[0]) return false;
            prevInterval = currInterval;
        }

        return true;
    }
}
