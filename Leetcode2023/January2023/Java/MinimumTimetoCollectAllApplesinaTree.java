class Solution {
	public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
		List<List<Integer>> adjacencyList = new ArrayList<>();

		for(int i=0;i<n;i++)
		{
			adjacencyList.add(new ArrayList<Integer>(0));
		}
		boolean visited[] = new boolean[n];

		for(int[] e:edges){
			adjacencyList.get(e[0]).add(e[1]);
			adjacencyList.get(e[1]).add(e[0]);
		}

		return dfs(adjacencyList,visited,hasApple,0);
	}

	private int dfs(List<List<Integer>> adjacencyList,boolean[] visited,List<Boolean> hasApple,int index)
	{
		int appleCollectedTime = 0;

		visited[index] = true;

		for(int i:adjacencyList.get(index))
		{
			if(!visited[i])
			{
				appleCollectedTime += dfs(adjacencyList,visited,hasApple,i);
			}
		}

		if(index == 0)
		{
			return appleCollectedTime;
		}

		if(hasApple.get(index) || appleCollectedTime >0) {
			appleCollectedTime += 2;
		}


		return appleCollectedTime;
	}

}