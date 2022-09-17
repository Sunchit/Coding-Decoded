class Solution {
	// TC : O(n * len String)
	// SC : O(1)
	public int numberOfBeams(String[] bank) {
		int pSecurityDevicesFreq=0;
		int ans=0;
		for(String s: bank){
			int cSecurityDevicesFreq=0;
			for(char c: s.toCharArray()){
				if(c=='1'){
					cSecurityDevicesFreq++;
				}
			}
			if(cSecurityDevicesFreq>0){
				ans+=(cSecurityDevicesFreq*pSecurityDevicesFreq);
				pSecurityDevicesFreq=cSecurityDevicesFreq;
			}
		}
		return ans;
	}
}