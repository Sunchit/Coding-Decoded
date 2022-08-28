// https://leetcode.com/problems/restore-ip-addresses/
// @author: anuj0503
class Solution {
    ArrayList<String> result;
    public List<String> restoreIpAddresses(String s) {
        result = new ArrayList<>();

        if(s.length() < 4 || s.length() > 12) return result;
        
        generateIP(0, new ArrayList<>(), s);

        return result;
    }

    private void generateIP(int index, ArrayList<Long> r, String s){
        if(index >= s.length()) return;

        if(r.size() == 3){
            if(index != s.length() - 1 && s.charAt(index) == '0') return;

            long num = Long.parseLong(s.substring(index));

            if(num <= 255){
                StringBuilder sb = new StringBuilder();

                for(Long lNum : r){
                    sb.append(String.valueOf(lNum)).append(".");
                }

                result.add(sb.toString() + s.substring(index));
            }
        }


        for(int i = index; i < s.length(); i++) {

            if (s.charAt(index) == '0') {
                r.add(0L);
                generateIP(i + 1, r, s);
                r.remove(r.size() - 1);
                break;
            } else {
                long num = Long.parseLong(s.substring(index, i + 1));

                if (num <= 255) {
                    r.add(num);
                    generateIP(i + 1, r, s);
                    r.remove(r.size() - 1);
                }
            }
        }
    }
}
