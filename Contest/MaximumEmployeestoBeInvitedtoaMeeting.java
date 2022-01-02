class Solution {
    int N;
    Map<Integer, List<Integer>> graph = new HashMap<>();
    int singleMaxCycleSize = 0;
    List<List<Integer>> pairs = new ArrayList<>();
    int[] favorite;
    public int maximumInvitations(int[] favorite) {
        this.favorite = favorite;
        N = favorite.length;
        //1. construct the graph by relationship
        for (int i = 0; i < favorite.length; i++) {
            int pre = favorite[i];
            int cur = i;
            graph.putIfAbsent(pre, new ArrayList<>());
            graph.get(pre).add(cur);
        }
        //2. count the cycle size
        countCycle();
        return Math.max(singleMaxCycleSize, countSizeTwoExtra());
    }

    //this method is for extend from size2 cycle, we can only extend one path from
    //one of the two node, if they can both extend, we add all, or we can only extend one side
    Map<Integer, Integer> max = new HashMap<>();
    private int countSizeTwoExtra() {
        boolean[] visited = new boolean[N];
        int res = 0;
        for (List<Integer> pair : pairs) {
            int a = pair.get(0);
            int b = pair.get(1);
            max.put(a, 0);
            max.put(b, 0);

            visited[a] = true;
            dfs(b, visited, 0, b);
            visited[a] = false;

            visited[b] = true;
            dfs(a, visited, 0, a);
            visited[b] = false;

            if (max.get(a) > 0 && max.get(b) > 0) res += (max.get(a) + max.get(b));
            else if (max.get(a) > max.get(b)) res += max.get(a);
            else res += max.get(b);
            res += 2;
        }
        return res;
    }

    //this method is for checking if we can extend from one node (not go back to its pair)
    private void dfs(int cur, boolean[] visited, int len, int start) {
        if (visited[cur]) return;
        max.put(start, Math.max(max.get(start), len));
        visited[cur] = true;
        for (int nei : graph.getOrDefault(cur, new ArrayList<>()))
            if (!visited[nei])
               dfs(nei, visited, len + 1, start);
        visited[cur] = false;
    }

    //this method if for count maxSize cycle, and also store all possible size=2 cycle
    private void countCycle() {
        boolean[] visited = new boolean[N];
        boolean[] recStack = new boolean[N];
        for (int i = 0; i < N; i++)
            isCyclicUtil(i, visited, recStack, 0);
    }
    private void isCyclicUtil(int i, boolean[] visited, boolean[] recStack, int count) {
        if (recStack[i]) {
            singleMaxCycleSize = Math.max(singleMaxCycleSize, count);
            if (count == 2) pairs.add(List.of(i, favorite[i]));
            return;
        }
        if (visited[i]) return;
        visited[i] = true;
        recStack[i] = true;
        List<Integer> children = graph.getOrDefault(i, new ArrayList<>());
        for (Integer c: children)
            isCyclicUtil(c, visited, recStack, count + 1);
        recStack[i] = false;
    }
}