class Solution {
    // TC : O(n)
    private int[] res;
    private int[] count;
    private List<HashSet<Integer>> tree;
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        tree = new ArrayList<HashSet<Integer>>();
        res = new int[N];
        count = new int[N];
        for (int i = 0; i < N ; ++i)
            tree.add(new HashSet<Integer>());
        for (int[] e : edges) {
            tree.get(e[0]).add(e[1]);
            tree.get(e[1]).add(e[0]);
        }
        postOrder(0, -1);
        preOrder(0, -1);
        return res;
    }

    public void postOrder(int root, int pre) {
        for (int i : tree.get(root)) {
            if (i == pre) continue;
            postOrder(i, root);
            count[root] += count[i];
            res[root] += res[i] + count[i];
        }
        count[root]++;
    }


    public void preOrder(int root, int pre) {
        for (int i : tree.get(root)) {
            if (i == pre) continue;
            res[i] = res[root] - count[i] + count.length - count[i];
            preOrder(i, root);
        }
    }
}