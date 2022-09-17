
// @saorav21994
// Simple DFS for each letter in a pre-defined map

class Solution {
    
    HashMap<Character, ArrayList<String>> map = new HashMap<Character, ArrayList<String>>();
        
    public List<String> letterCombinations(String digits) {
        
        map.put('2', new ArrayList(Arrays.asList("a","b","c")));
        map.put('3', new ArrayList(Arrays.asList("d","e","f")));
        map.put('4', new ArrayList(Arrays.asList("g","h","i")));
        map.put('5', new ArrayList(Arrays.asList("j","k","l")));
        map.put('6', new ArrayList(Arrays.asList("m","n","o")));
        map.put('7', new ArrayList(Arrays.asList("p","q","r","s")));
        map.put('8', new ArrayList(Arrays.asList("v","t","u")));
        map.put('9', new ArrayList(Arrays.asList("w","x","y","z")));
        
        if (digits.length() == 0) return Collections.emptyList();
        
        ArrayList<String> res = new ArrayList<String>();
        combine(res, digits, 0, digits.length(), "");
        
        return res;
        
    }
    
    public void combine(ArrayList<String> res, String digits, int idx, int maxlen, String cur) {
        if (cur.length() == maxlen) {
            res.add(cur);
            return;
        }
        
        for (int i = 0; i < map.get(digits.charAt(idx)).size(); i++) {
            combine(res, digits, idx+1, maxlen, cur+map.get(digits.charAt(idx)).get(i).toString());
        }
    }
}
