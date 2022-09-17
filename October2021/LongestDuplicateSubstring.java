//TC: O(nlogn)
class Solution {

	private int primeNo = 37;
	public String longestDupSubstring(String s) {
		int low=0;
		int high=s.length();

		String ans ="";
		while(low<high){
			int mid=low + (high -low)/2;

			String str=duplicateStr(s,mid);
			if(str!=null && str.length()!=0){
				ans=str;
				low=mid+1;
			}else{
				high=mid;
			}
		}
		return ans;
	}

	private String duplicateStr(String s,int len){
		// Hashes for a particular string
		Set<Long> set=new HashSet<>();

		long currHash=getHash(s.substring(0,len));

		set.add(currHash);

		long pow=1;

		for(int l=1;l<len;l++) pow*=primeNo;

		for(int i=1;i<=s.length()-len;i++){
			currHash = nextHash(pow, currHash,s.charAt(i-1),s.charAt(i+len-1));
			if(set.contains(currHash)){
				// found duplicate
				return s.substring(i,i+len);
			}
			set.add(currHash);
		}
		return null;
	}

	private long nextHash(long pow,long oldHash,char left,char right){
		return (oldHash - left*pow)*primeNo + right;

	}

	private long getHash(String s) {
		long hash = 0;
		long factor=1;
		for (int i = s.length()-1; i >=0; i--) {
			hash += s.charAt(i)*factor;
			factor*=primeNo;
		}
		return hash;
	}
}