// https://leetcode.com/problems/merge-similar-items/
// @author: anuj0503
class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        List<List<Integer>> result = new ArrayList<>();
        
        for(int[] i :items1){
            map.put(i[0], i[1]);
        }
        
        for(int[] i : items2){
            if(map.get(i[0]) != null){
                Integer w = map.get(i[0]);
                w += i[1];
                
                map.put(i[0], w);
            } else {
                map.put(i[0], i[1]);
            }
        }
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            ArrayList<Integer> al = new ArrayList<>();
            al.add(entry.getKey());
            al.add(entry.getValue());
            
            result.add(al);
        }
        
        return result;
    }
}
