// https://leetcode.com/problems/query-kth-smallest-trimmed-number/
// @author: anuj0503
class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int[] result = new int[queries.length];
        
        for(int i = 0; i < queries.length; i++){
            PriorityQueue<Pair<String, Integer>> pq = new PriorityQueue<>(new Comparator<Pair<String, Integer>>(){
                    @Override
                    public int compare(Pair<String, Integer> p1, Pair<String, Integer> p2){
                        if(p1.getKey().equals(p2.getKey())){
                            return p2.getValue() - p1.getValue();
                        }
                        
                        return p2.getKey().compareTo(p1.getKey());
                    }
                });
            
            for(int j = 0; j < nums.length; j++){
                pq.offer(new Pair<String, Integer>(nums[j].substring(nums[j].length() - queries[i][1]), j));
                
                if(pq.size() == queries[i][0] + 1){
                    pq.poll();
                }
            }
            
            result[i] = pq.poll().getValue();
        }
        
        return result;
    }
}
