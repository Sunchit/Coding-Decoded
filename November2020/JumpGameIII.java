class JumpGameIII {
    public boolean canReach(int[] arr, int start) {
        // O(n) : TC
        // O(n) : SC boolean array
        Queue<Integer> qu = new LinkedList<>();
        boolean[] visited = new boolean[arr.length];
        qu.offer(start);
        while(!qu.isEmpty()){
            int size = qu.size();
            while(size-->0){
                Integer head = qu.poll();
                if(arr[head] == 0){
                    return true;
                }
                if(!visited[head]){
                    int forwardIndex = head + arr[head];
                    if(forwardIndex>=0 && forwardIndex <arr.length){
                        qu.offer(forwardIndex);

                    }
                    int backwardIndex = head - arr[head];
                    if(backwardIndex>=0 && backwardIndex <arr.length){
                        qu.offer(backwardIndex);

                    }
                    visited[head] = true;
                }
            }
        }

        return false;

    }
}