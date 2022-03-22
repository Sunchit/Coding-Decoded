
// @saorav21994
// TC : O(n)
// SC : O(n)

class Solution {
    public String getSmallestString(int n, int k) {
        char [] res = new char[n];
        Arrays.fill(res, 'a');
        k -= n;
        while (k > 0) {
            res[--n] += Math.min(25, k);
            k -= Math.min(25, k);
        }
        return String.valueOf(res);
    }
}
