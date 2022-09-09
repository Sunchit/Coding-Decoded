// https://leetcode.com/problems/meeting-rooms-ii/
// @author: anuj0503
public class Solution{
    public int minMeetingRooms(int[][] intervals){
        if(intervals == null || intervals.length == 0) return 0;
        if(intervals.length == 1) return 1;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        pq.add(intervals[0]);
        int result = 0;
        for(int i = 1; i < intervals.length; i++){
            int[] currInterval = intervals[i];
            int[] prevInterval = pq.poll();

            if(currInterval[0] < prevInterval[1]){
                pq.add(currInterval);
                pq.add(prevInterval);
            } else {
                prevInterval = currInterval;
                pq.add(prevInterval);
            }
        }

        return pq.size();
    }
}
