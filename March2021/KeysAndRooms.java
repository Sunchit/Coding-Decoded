class Solution {

    // TC : O(n2)
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visitedRoomIDs = new HashSet<>();
        Queue<Integer> qu =new LinkedList<>();
        qu.offer(0);
        visitedRoomIDs.add(0);
        while(!qu.isEmpty()){
            int size = qu.size();
            while(size-->0){
                Integer head = qu.poll();
                for(Integer nextRoomId: rooms.get(head)){
                    if(!visitedRoomIDs.contains(nextRoomId)){
                        qu.offer(nextRoomId);
                        visitedRoomIDs.add(nextRoomId);
                    }
                }
            }
        }

        return rooms.size() == visitedRoomIDs.size();

    }
}