
// @saorav21994
// TC : O(n)
// SC : O(1)

// Max of all digits

class Solution {
    public int minPartitions(String n) {
        int res = 0;
        for (char ch : n.toCharArray()) {
            res = Math.max(res, ch-48);
        }
        return res;
    }
}
