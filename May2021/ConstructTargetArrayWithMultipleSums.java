class Solution {
    // TC : O(nlogn)
    // SC : O(n)
    public boolean isPossible(int[] target) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (b-a)); // MAX heap
        long totalSum = 0l;

        for(int el: target){
            pq.add(el);
            totalSum = totalSum + el;
        }

        while(!pq.isEmpty()){
            int maxEl = pq.poll();
            long remaingTotal = totalSum - maxEl;

            if(maxEl == 1 || remaingTotal == 1){
                return true;
            }
            if(remaingTotal == 0 || maxEl < remaingTotal){
                return false;
            }

            int updatedMax = (int)(maxEl % remaingTotal);

            if(updatedMax ==0){
                return false;
            }

            maxEl = updatedMax;
            pq.offer(maxEl);
            totalSum = updatedMax + remaingTotal;
        }

        return true;
    }
}