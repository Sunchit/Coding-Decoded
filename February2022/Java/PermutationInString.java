

class Solution {
    public boolean checkInclusion(String t, String s) {
        List<Integer> ans = new ArrayList<>();

        int unmatchingCharCount = t.length();

        if(t.length()>s.length()){
            return false;
        }

        int[] freqCount = new int[26];

        for(int i=0;i<t.length();i++){
            int index = t.charAt(i)-'a';
            freqCount[index]++;
        }

        int start =0;
        int end =0;
        for(;end<t.length();end++) {
            int index = s.charAt(end)-'a';
            if(freqCount[index]>0){

                unmatchingCharCount--;
            }
            freqCount[index]--;

        }
        if(unmatchingCharCount==0){
            return true;

        }
        for(;end<s.length();){
            // remove starting index
            int indexStart = s.charAt(start) -'a';

            if(freqCount[indexStart]>=0) {
                // char was present in t
                unmatchingCharCount++;
            }

            freqCount[indexStart]++;

            start++;

            int indexEnd = s.charAt(end)-'a';
            if(freqCount[indexEnd]>0){
                unmatchingCharCount--;
            }
            freqCount[indexEnd]--;

            end++;

            if(unmatchingCharCount==0){
                return true;
            }

        }

        return false;

    }

}

// @saorav21994
// TC : O(l1+l1+(l2-l1)) = O(l1+ l2)
// SC : O(26+26) = O(52) = Constant

/*
  Sliding window technique is used. 
*/

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int [] hash1 = new int[26];
        int [] hash2 = new int[26];
        for (char ch : s1.toCharArray()) {
            hash1[(int)ch-97] += 1;
        }
        
        int sublen = s1.length();
        int matlen = 0;
        for (int i = 0; i < sublen; i++) {
            hash2[(int)s2.charAt(i)-97] += 1;
            if (hash1[(int)s2.charAt(i)-97] >= hash2[(int)s2.charAt(i)-97]) matlen += 1;
        }
        
        if (matlen == sublen) return true;
        int biglen = s2.length();
        for (int i = sublen ; i < biglen; i++) {
            if (hash1[(int)s2.charAt(i-sublen)-97] >= hash2[(int)s2.charAt(i-sublen)-97]) {
                matlen -= 1;
            }
            hash2[(int)s2.charAt(i-sublen)-97] -= 1;
            hash2[(int)s2.charAt(i)-97] += 1;
            if (hash1[(int)s2.charAt(i)-97] >= hash2[(int)s2.charAt(i)-97]) {
                matlen += 1;
            }
            if (matlen == sublen) return true;
        }
        return false;
    }
}
