class Solution {
	// TC: O(nlogn)
	// SC : O(n)
	public int largestInteger(int num) {

		PriorityQueue<Integer> oddPQ = new PriorityQueue<>((a,b) ->(b-a));
		PriorityQueue<Integer> evenPQ = new PriorityQueue<>((a,b) ->(b-a));

		String str = num+"";
		for(char c: str.toCharArray()){
			int el = c - '0';
			if(el%2==0){
				evenPQ.offer(el);
			} else {
				oddPQ.offer(el);
			}
		}


		String ans = "";

		for(char c: str.toCharArray()){
			int el = c - '0';
			if(el%2==0){
				ans += (evenPQ.poll()+"");
			} else {
				ans += (oddPQ.poll()+"");
			}
		}


		return Integer.parseInt(ans);
	}
}