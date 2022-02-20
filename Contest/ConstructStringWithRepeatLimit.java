class Solution {

	private class Pair{
		char key;
		int val;

		Pair(char key,int val){
			this.key = key;
			this.val = val;
		}
	}

	// TC : O(nlogn)
	public String repeatLimitedString(String s, int repeatLimit) {

		int[] freq = new int[26];
		for(char c: s.toCharArray()){
			freq[c-'a']++;
		}

		PriorityQueue<Pair> maxHeap = new PriorityQueue<>((Pair a,Pair b)->b.key-a.key);
		for(int i=0;i<26;i++){
			if(freq[i]>0){
				maxHeap.add(new Pair((char)('a'+i),freq[i]));
			}
		}

		StringBuilder ans = new StringBuilder();
		while(maxHeap.size()>0){
			// highest lexicographically element
			Pair pair = maxHeap.poll();
			int count = pair.val;

			// consume the highest element uptill repeatLimit
			for(int i=0;i<repeatLimit && count>0;i++){
				ans.append(pair.key);
				count--;
			}

			if(count>0 && maxHeap.size()>0){
				Pair secondHighestPair = maxHeap.poll();
				ans.append(secondHighestPair.key);
				if(secondHighestPair.val>1){
					maxHeap.add(new Pair(secondHighestPair.key,secondHighestPair.val-1));
				}
				maxHeap.add(new Pair(pair.key,count));

			}
		}

		return ans.toString();
	}



}
