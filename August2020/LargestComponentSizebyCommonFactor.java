
class LargestComponentSizebyCommonFactor {
    public int largestComponentSize(int[] A) {

        // Highest rank parent, size of its subset
        Map<Integer,Integer> map = new HashMap<>();

        int maxEl = A[0];
        for(int i=1; i<A.length; i++){
            maxEl = Math.max(A[i], maxEl);
        }

        UnionFind unionFind = new UnionFind(maxEl);

        // 20 <=4
        // 2, 4 (5, 10)
        for(int el:A) {
            for(int num=2;num<=Math.sqrt(el);num++) {

                if(el%num==0) {
                    unionFind.union(el,num);
                    unionFind.union(el,el/num);
                }

            }
        }

        int ans = 0;

        for(int el: A) {
            // find the topmost parent
            int topParent = unionFind.find(el);
            map.put(topParent, map.getOrDefault(topParent, 0) + 1);

            ans = Math.max( ans, map.get(topParent) );
        }

        return ans;
    }
}


class UnionFind {
    int parent[];
    int rank[];

    UnionFind(int max) {

        // starting from 0 to Max initialize 2 arrays
        this.parent = new int[max+1];
        this.rank = new int[max+1];

        // treat all the nodes as independent of each other
        for(int i=0;i<=max;i++) {
            parent[i] = i;
        }
    }

    public void union(int a,int b) {

        int pA = find(a);
        int pB = find(b);

        if(pA == pB) {
            return;
        }

        if(rank[pA] < rank[pB]) {
            parent[pA] = pB;
        } else if(rank[pA] > rank[pB]) {
            parent[pB] = pA;
        } else {
            // since rank of both the elements is equal (can make one A parent of B or vice versa)
            parent[pA] = pB;
            rank[pB]++;
        }

    }


    public int find(int a) {
        while(a != parent[a]) {
            parent[a]= parent[parent[a]];
            a = parent[a];
        }

        return a;
    }


}