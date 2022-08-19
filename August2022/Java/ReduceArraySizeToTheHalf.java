
// @saorav21994
// TC : O(n)
// SC : O(n)

class Solution {
    public int minSetSize(int[] arr) {
        int l = arr.length;
        int [] hash = new int[100010];
        for (int ele : arr) {
            hash[ele] += 1;
            if (hash[ele] >= l/2) return 1;
        }
        Arrays.sort(hash);
        int hl = l/2;
        int j = 100009;
        int res = 0;
        while (l > hl) {
            l -= hash[j];
            j -= 1;
            res += 1;
        }
        return res;
    }
}
