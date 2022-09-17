class Solution {
    public String orderlyQueue(String s, int k) {
        if(k==0){
            return s;
        }
        else if (k > 1) {
            char[] charS = s.toCharArray();
            Arrays.sort(charS);
            return new String(charS);

        } else if(k==1) {
            String ans = s;
            for (int i = 1; i < s.length(); i++) {
                String reorderedStr = s.substring(i) + s.substring(0, i);
                if (ans.compareTo(reorderedStr) > 0) {
                    ans = reorderedStr;
                }
            }
            return ans;
        }
        return s;

    }
}