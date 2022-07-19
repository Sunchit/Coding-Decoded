// https://leetcode.com/problems/count-good-meals/
// @author: anuj0503
class Solution {
    public int countPairs(int[] deliciousness) {
        ArrayList<Integer> al = new ArrayList<>();
        long result = 0;
        
        System.out.println(deliciousness.length);
        for(int i = 0; i <= 21; i++){
            al.add((int)Math.pow(2, i));
        }
        
        Map<Integer, Long> map = new HashMap<>();
        
        for(Integer i : deliciousness){
            map.putIfAbsent(i, 0L);
            map.put(i, map.get(i) + 1);
        }
        
        // System.out.println(map);
        for(Integer firstEl : map.keySet()){
            for(Integer powerOfTwo : al){
                int secondEl = powerOfTwo - firstEl;
                
                if(secondEl == firstEl){
                    System.out.println(firstEl);
                    Long freq = map.get(secondEl);
                    
                    if(freq%2==0){
                        result += (freq/2*(freq-1))%1000000007;
                    } else {
                        result += (freq*((freq-1)/2))%1000000007;
                    }
                    
                } else if(secondEl > firstEl && map.get(secondEl) != null){
                    System.out.println(firstEl);
                    result += (map.get(secondEl) * map.get(firstEl));
                }
                
                result %= 1000000007;
            }
        }
        
        return (int)result;
    }
}
