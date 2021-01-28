class Solution {
    // TC: O(n)
    //SC: O(n)
    public String getSmallestString(int n, int k) {
        char[] ans = new char[n];
        for(int i=0;i<n;i++){
            ans[i] = 'a';
            k--;
        }
        int index = ans.length-1;
        while(k>=26){
            ans[index] = 'z';
            k = k+1-26;
            index--;
        }

        ans[index] = (char)(k +'a');
        return new String(ans);

    }
}