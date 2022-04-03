class Solution {
	// TC : O(n)
	// SC : O(Total players O(n)*2)
	public List<List<Integer>> findWinners(int[][] matches) {
		List<List<Integer>> ans = new ArrayList<>();
		Set<Integer> allPlayers = new HashSet<>();

		Map<Integer, Integer> map = new HashMap<>();

		Set<Integer> losers = new HashSet<>();

		Set<Integer> nonLosers = new HashSet<>();

		Set<Integer> lostOneMatch = new HashSet<>();

		for(int[] match: matches){
			allPlayers.add(match[0]);
			allPlayers.add(match[1]);
			losers.add(match[1]);

			int lostTimes = map.getOrDefault(match[1], 0);
			map.put(match[1], lostTimes+1);
		}


		for(Integer player: allPlayers){
			if(!losers.contains(player)){
				nonLosers.add(player);
			}
		}

		for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
			if(entry.getValue() == 1) {
				lostOneMatch.add(entry.getKey());
			}

		}



		List<Integer> nonLosersList = new ArrayList<>(nonLosers);
		Collections.sort(nonLosersList);

		ans.add(new ArrayList<>(nonLosersList));

		List<Integer> lostOneMatchList = new ArrayList<>(lostOneMatch);
		Collections.sort(lostOneMatchList);
		ans.add(lostOneMatchList);


		return ans;

	}
}