// https://leetcode.com/contest/weekly-contest-314/problems/find-the-original-array-of-prefix-xor/
// @author: anuj0503
class Solution {
    public int[] findArray(int[] pref) {
        int[] result = new int[pref.length];
        
        result[0] = pref[0];
        
        for(int i = 1; i < pref.length; i++){
            result[i] = pref[i] ^ pref[i - 1];
        }
        
        return result;
    }
}
