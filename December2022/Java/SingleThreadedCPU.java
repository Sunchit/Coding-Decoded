class Solution {
	public int[] getOrder(int[][] tasks) {

		int[][] allTasks = new int[tasks.length][3]; // index, starting time and totalTime
		for (int i = 0; i < tasks.length; i++) {
			allTasks[i][0] = i; // index
			allTasks[i][1] = tasks[i][0]; // availableTime
			allTasks[i][2] = tasks[i][1]; // ProcessingTime
		}
		// Sort on the basis of duration first then index
		Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2] == 0 ? a[0] - b[0] : a[2] - b[2]);
		// sort on the basis of availabliity

		Arrays.sort(allTasks, (a, b) -> a[1] - b[1]);

		int i = 0, index = 0, curTime = 0;
		int[] result = new int[tasks.length];

		while (i < tasks.length) {
			// check if i th tasks starting time is smaller or equal to currenttime
			while (i < tasks.length && curTime >= allTasks[i][1]) {
				minHeap.add(allTasks[i++]);
			}
			if (minHeap.isEmpty()) {
				curTime = allTasks[i][1];
			}
			if (!minHeap.isEmpty()) {
				int[] curTask = minHeap.poll();
				result[index++] = curTask[0];
				curTime += curTask[2];
			}
		}

		while (!minHeap.isEmpty()) {
			int[] curTask = minHeap.poll();
			result[index++] = curTask[0];
		}
		return result;
	}
}