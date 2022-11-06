// @saorav21994

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int l = strs.length;
        HashMap<String, Integer> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < l; i++) {
            char [] tmp = strs[i].toCharArray();
            Arrays.sort(tmp);
            String s = String.valueOf(tmp);
            if (map.containsKey(s) == true) {
                int idx = map.get(s);
                res.get(idx).add(strs[i]);
            }
            else {
                res.add(new ArrayList<>(Arrays.asList(strs[i])));
                map.put(s, res.size()-1);
            }
        }
        return res;
    }
}
