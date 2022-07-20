// https://leetcode.com/problems/number-of-matching-subsequences/
// @author: anuj0503
// Binary Search Approach
class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        ArrayList<Integer>[] mapping = new ArrayList[26];
        int result = 0;
        
        for(int i = 0; i <  26; i++) mapping[i] = new ArrayList<Integer>();
        
        for(int i = 0; i < s.length(); i++){
            mapping[s.charAt(i) - 'a'].add(i);
        }
        
        for(String word : words){
            int index = -1;
            int i = 0;
            
            while(i < word.length()){
                index = getIndex(mapping[word.charAt(i) - 'a'], index);
                
                if(index == -1)
                    break;
                
                i++;
            }
            
            if(i == word.length()){
                result++;
            }
        }
        
        return result;
    }
    
    private int getIndex(ArrayList<Integer> arr, int key){
        int low = 0, high = arr.size() - 1;
        
        while(low < high){
            int mid = low + (high - low)/2;
            
            if(arr.get(mid) <= key){
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        
        if(low < arr.size() && key >= arr.get(low)){
            low++;
        }
        
        if(low == arr.size())
            return -1;
        
        return arr.get(low);
        
    }
}
