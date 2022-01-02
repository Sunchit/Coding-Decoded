class Solution {
	public int numberOfBeams(String[] bank) {
		int ans = 0;
		int[] countOne = new int[bank.length];
		int i=0;
		for(String row : bank){
			int freq = 0;
			for(char c: row.toCharArray()){
				if(c == '1'){
					freq++;
				}
			}
			countOne[i++] = freq;
		}
		for(int k = 0;k<bank.length;k++){
			if(countOne[k]==0){
				continue;
			} else {
				int el = countOne[k];
				int p = k+1;
				while(p<bank.length && countOne[p]==0){
					p++;
				}
				if(p<bank.length){
					ans += countOne[k] *countOne[p];
				}


			}

		}
		return ans;

	}
}