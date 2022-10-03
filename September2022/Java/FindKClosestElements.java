
// @saorav21994

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
         // Initialize binary search bounds
        int left = 0;
        int right = arr.length - k;
        
        // Binary search against the criteria described
        while (left < right) {
            int mid = (left + right) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        // Create output in correct format
        List<Integer> result = new ArrayList<Integer>();
        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }
        
// https://leetcode.com/problems/find-k-closest-elements/
// @author: anuj0503
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o2[0] - o1[0];
                }
                return o2[1] - o1[1];
            }
        });

        for (int i = 0; i < arr.length; i++) {
            pq.offer(new int[]{i, Math.abs(arr[i] - x)});

            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<Integer> result = new ArrayList<>();
        
        while(!pq.isEmpty()){
            result.add(arr[pq.poll()[0]]);
        }
        
        Collections.sort(result);
        
        return result;
    }
}


================== Second Approach ========================
  class Pair{
    private Integer index;
    private Integer diff;

    Pair(int ind, int dif){
        index = ind;
        diff = dif;
    }
    
    public Integer getIndex(){
        return index;
    }
    
    public Integer getDiff(){
        return diff;
    }
}

class PairCompare implements Comparator<Pair>{
    public int compare(Pair a, Pair b){
        if(a.getDiff() == b.getDiff())
            return a.getIndex() - b.getIndex();
        return a.getDiff() - b.getDiff();
    }
}

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int arrLen = arr.length;
        
        ArrayList<Pair> pairAl = new ArrayList<Pair>();
         for(int i = 0; i < arrLen; i++)
             pairAl.add(new Pair(i, Math.abs(arr[i] - x)));
        
        Collections.sort(pairAl, new PairCompare());
        
        List<Integer> result = new ArrayList<Integer>();
        
        for(Pair p : pairAl){
            result.add(arr[p.getIndex()]);
            k--;
            
            if(k == 0)
                break;
        }
        Collections.sort(result);
        return result;
    }
}
