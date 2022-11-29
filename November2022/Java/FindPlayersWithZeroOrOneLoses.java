
// @saorav21994

class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        
        int [] win = new int[100005];
        int [] lose = new int[100005];

        for (int [] match : matches) {
            win[match[0]] += 1;
            lose[match[1]] += 1;
        }

        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        res.add(new ArrayList<>());

        for (int i = 0; i < 100005; i++) {
            if (win[i] > 0 && lose[i] == 0) {
                res.get(0).add(i);
            }
            else if (win[i] >= 0 && lose[i] == 1) {
                res.get(1).add(i);
            }
        }

        return res;

    }
}
