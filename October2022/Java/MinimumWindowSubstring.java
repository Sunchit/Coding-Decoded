
// @saorav21994

class Solution {
    public String minWindow(String s, String t) {
        String res = "";
        HashMap<Character, Integer> smap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> tmap = new HashMap<Character, Integer>();
        int req = t.length();
        int cur = 0; 
        int i = -1;
        int j = -1;
        for (char ch : t.toCharArray()) {
            tmap.put(ch, tmap.getOrDefault(ch, 0) + 1);
        }
        while(true) {
            int flag1 = 0, flag2 = 0;
            while(i < s.length()-1 && cur < req) {
                i += 1;
                char ch = s.charAt(i);
                smap.put(ch, smap.getOrDefault(ch, 0) + 1);
                if (smap.getOrDefault(ch, 0) <= tmap.getOrDefault(ch, 0)) {
                    cur += 1;
                }
                flag1 = 1;
            }
            while(j < i && cur == req) {
                String prob = s.substring(j+1, i+1);
                // System.out.println("prob = " + prob);
                j += 1;
                if (res.length() == 0 || res.length() > prob.length()) {
                    res = prob;
                }
                char ch = s.charAt(j);
                smap.put(ch, smap.getOrDefault(ch, 0) - 1);
                if (smap.get(ch) < tmap.getOrDefault(ch, 0)) {
                    cur -= 1;
                }
                flag2 = 1;
            }
            if (flag1 == 0 && flag2 == 0) {
                break;
            }
        }
        
        return res;
    }
}
