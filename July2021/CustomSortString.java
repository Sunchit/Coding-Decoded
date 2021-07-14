class Solution {
  // O(Len(Str + Order))
  public String customSortString(String order, String str) {
    int[] freq = new int[26];

    // TC : O(len of Str)
    for(char c : str.toCharArray()){
      freq[c-'a']++;
    }

    StringBuilder ans = new StringBuilder();

    // TC : O(Len(orderStr + Str))
    for(char orderChar: order.toCharArray()) {

      while(freq[orderChar-'a']>0) {
        ans.append(orderChar);
        freq[orderChar-'a']--;
      }
    }

    // TC : O(Len(Str))
    for(int i=0;i<26;i++){
      int freqC = freq[i];
      while(freqC>0) {
        ans.append((char)(i+'a'));
        freqC--;
      }
    }
    return ans.toString();
  }
}