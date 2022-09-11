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