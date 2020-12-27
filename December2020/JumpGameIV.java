class Solution {
    // TC : O(n2)
    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            List<Integer> indices = map.getOrDefault(arr[i], new ArrayList<>());
            indices.add(i);
            map.put(arr[i], indices);
        }

        Queue<Integer> qu = new LinkedList<>();
        qu.offer(0);

        boolean[] visited= new boolean[arr.length];
        int level = 0;
        while(!qu.isEmpty()){
            int size = qu.size();
            while(size-->0){
                Integer head = qu.poll();


                if(head == arr.length -1){
                    return level;
                }

                if(head <0 || head>=arr.length || visited[head]){
                    continue;
                }

                if(head - 1 >0 && !visited[head-1]) {
                    qu.offer(head-1);
                }

                if(head + 1 <arr.length && !visited[head+1]) {
                    qu.offer(head+1);
                }

                if(map.containsKey(arr[head])){
                    for(int index : map.get(arr[head])){
                        if(index>=0 && index<arr.length && !visited[index]){
                            qu.offer(index);
                        }
                    }
                    map.remove(arr[head]);
                }
                visited[head] = true;
            }
            level++;

        }
        return -1;

    }
}