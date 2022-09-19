
// @saorav21994

class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        
        for (String path : paths) {
            String [] del = path.split(" ");
            String dir = del[0] + "/";
            // System.out.println(dir);
            int l = del.length;
            for (int i = 1; i < l; i++) {
                String [] spliter = del[i].split("\\(");
                String file = spliter[0];
                String content = spliter[1].substring(0, spliter[1].length());
                String value = dir + file;
                // System.out.println(value + " " + content);
                if (map.containsKey(content) == false) {
                    map.put(content, new ArrayList<String>());
                }
                map.get(content).add(value);
            }
        }
        for (Map.Entry<String, List<String>> et : map.entrySet()) {
            if (et.getValue().size() > 1) {
                res.add(et.getValue());
            }
        }
        // res.add(new ArrayList<String>());
        return res;
    }
}
