// https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/
// @author: @anuj0503
class Solution {
    public int minimumRecolors(String blocks, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = blocks.length();
        map.put(-1, 0);
        int count = 0;
        for (int i = 0; i < n; i++){
            if(blocks.charAt(i) == 'W') count++;

            map.put(i, count);
        }

        int result = 10000;
        for (int i = 0; i < n; i++){
            int j = i + k - 1;

            if(j < n)
                result = Math.min(result, map.get(j) - map.get(i - 1));
        }

        return result;
    }
}
