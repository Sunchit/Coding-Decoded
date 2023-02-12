class Solution {
	// TC : O(n)
	// SC : O(n)
	private  long fuel = 0l;
	private int seats;

	public long minimumFuelCost(int[][] roads, int seats) {
		List<Integer>[] graph = new List[roads.length + 1];

		for(int i = 0; i <= roads.length; i++){
			graph[i] = new ArrayList<>();
		}
		for(int[] road : roads){
			int end1 = road[0];
			int end2 = road[1];
			graph[end1].add(end2);
			graph[end2].add(end1);
		}
		this.seats = seats;
		dfs(graph, 0, -1);
		return fuel;
	}
	public int dfs(List<Integer>[] graph, int currCity, int prevCity){

		int people = 1;

		for(int nextCity : graph[currCity]){
			if(nextCity == prevCity){
				continue;
			}
			people += dfs(graph, nextCity, currCity);
		}

		if(currCity != 0) { // final destination
			fuel += (long)(Math.ceil((double)people / this.seats));
		}
		return people;
	}
}