class Solution {
	// TC : O(nlogn)
	// SC : O(1)
	public int minGroups(int[][] intervals) {

		Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		for (int[] interval: intervals) {
			int left = interval[0];
			int right = interval[1];

			if (!minHeap.isEmpty() && left > minHeap.peek()) {
				// current interval safe be part of the same group as that of peek element
				minHeap.poll();
			}
			minHeap.offer(right);
		}

		return minHeap.size();
	}
}

============== Approach Using TreeSet (Same is used in LIS O(nlogn) solution) =============================
// @author: anuj0503
class Solution {
    public int minGroups(int[][] intervals) {
        int n = intervals.length;

        if(n == 1) return 1;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        for(int i = 0; i < n; i++){
            Integer lower = treeMap.lowerKey(intervals[i][0]);

            if(lower != null){
                int f = treeMap.get(lower);
                if(f == 1) treeMap.remove(lower);
                else treeMap.put(lower, f - 1);
            }
            treeMap.put(intervals[i][1], treeMap.getOrDefault(intervals[i][1], 0) + 1);
        }

        int result = 0;
        for(int num : treeMap.values()) result += num;
        return result;
    }
}
