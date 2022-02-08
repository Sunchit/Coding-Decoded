class Solution {2
	public int[] sortEvenOdd(int[] nums) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a,b) ->(b-a));

		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a,b) ->(a-b));

		for(int i=0;i<nums.length;){
			minHeap.offer(nums[i]);
			i = i+2;
		}

		for(int i=1;i<nums.length;){
			maxHeap.offer(nums[i]);
			i = i+2;
		}
		int i=0;
		while(!minHeap.isEmpty()){
			nums[i] = minHeap.poll();
			i = i + 2;
		}


		i=1;
		while(!maxHeap.isEmpty()){
			nums[i] = maxHeap.poll();
			i = i + 2;
		}
		return nums;
	}
}