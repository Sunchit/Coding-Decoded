
// @saorav21994

class Solution {
    public int maxLength(List<String> arr) {
        List<String> res = new ArrayList<>();
        res.add("");
        for (String str : arr) {
            if (checkCommon(str)) continue;
            List<String> resList = new ArrayList<>();
            for (String candidate : res) {
                String temp = candidate + str;
                if (checkCommon(temp) == false) resList.add(temp);
            }
            res.addAll(resList);
        }
        int ans = 0;
        for (String str : res) ans = Math.max(ans, str.length());
        return ans;
       
    }
    
    public boolean checkCommon(String a) {
        int [] hash = new int[26];
        for (char c : a.toCharArray()) {
            hash[(int)c-97] += 1;
            if (hash[(int)c-97] > 1)
                return true;
        }
        return false;
    }
}
