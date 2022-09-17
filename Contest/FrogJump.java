// https://leetcode.com/problems/frog-jump/
// @author: anuj0503
class Solution {
    int[] dir = new int[]{-1, 0, 1};
    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> indexMapping = new HashMap<>();
        int n = stones.length;
        
        for(int i = 0; i < n; i++){
            indexMapping.put(stones[i], i);
            
            map.put(i, new HashSet<Integer>());
        }
        
        Set<Integer> s = new HashSet<>();
        s.add(0);
        
        map.put(0, s);
        
        for(int i = 0; i < n; i++){
            if(!map.get(i).isEmpty()){
                for(Integer k : map.get(i)){
                    for(int d : dir){
                        int possibleJump = k + d;
                        
                        if(possibleJump > 0){
                            
                            if(stones[i] + possibleJump == stones[n-1]) return true;
                            
                            Integer nextStoneIndex = indexMapping.get(stones[i] + possibleJump);
                            if(nextStoneIndex != null){
                                
                                Set<Integer> nextStoneSet = map.get(nextStoneIndex);
                                nextStoneSet.add(possibleJump);
                                
                                map.put(nextStoneIndex, nextStoneSet);
                            }
                        }
                    }
                }
            }
        }
        
        return false;
    }
}
