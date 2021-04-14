class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> qu = new LinkedList<>();
        for(int i=1;i<=n;i++){
            qu.offer(i);
        }

        while(qu.size() !=1){
            for(int j=1;j<=k-1;j++){
                qu.offer(qu.poll());
            }
            // k th element
            qu.poll();
        }

        return qu.poll();
    }
}