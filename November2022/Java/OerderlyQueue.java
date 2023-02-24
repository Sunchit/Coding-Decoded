
// @saorav21994

class Solution {
    public String orderlyQueue(String s, int k) {
        /*
            k = 1, check each string lexicographically by beginning the string by each character
            k != 1, sort the string lexicographically and return then return the string
        */
        if (k == 1) {
            String res = s;
            for (int i = 0; i < s.length(); i++) {
                String tmp = s.substring(i) + s.substring(0,i);
                // System.out.println(tmp);
                // System.out.println(res.compareTo(tmp));
                if (res.compareTo(tmp) > 0)
                    res = tmp;
                // System.out.println("res = " + res);
                
            }
            return res;
        }
        
        char [] str = s.toCharArray();
        Arrays.sort(str);
        return String.valueOf(str);
    }
}


