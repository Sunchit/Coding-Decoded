class Solution {
	// TC : O(n)
	// SC : O(n)
	public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

		List<int[]> ans = new ArrayList<>();

		int fIndex = 0;
		int sIndex = 0;
		int mS, mE;
		while(fIndex < firstList.length && sIndex < secondList.length){
			mS = Math.max(firstList[fIndex][0], secondList[sIndex][0]);
			mE = Math.min(firstList[fIndex][1], secondList[sIndex][1]);

			if(mE >= mS)
				ans.add(new int[]{mS, mE});

			if(firstList[fIndex][1] == mE) fIndex++;
			if(secondList[sIndex][1] == mE) sIndex++;
		}

		return ans.toArray(new int[ans.size()][2]);
	}

}




