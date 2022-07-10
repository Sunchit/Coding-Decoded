class Solution {


	public int fillCups(int[] amount) {
		// Max Heap
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b) ->(b-a));

		for(int el: amount){
			pq.offer(el);
		}

		int ans = 0;

		while(!pq.isEmpty()) {

			int first = pq.poll();
			int second = pq.poll();

			if(first<=0 && second <=0) {
				break;
			}
			first--;
			second--;
			pq.offer(first);
			pq.offer(second);
			ans++;
		}
		return ans;
	}
}