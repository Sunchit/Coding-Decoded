
class Solution {
    public List<String> cellsInRange(String s) {
        char startC = s.charAt(0);
        int startR = s.charAt(1)-'0';
        char endC = s.charAt(3);
        int endR = s.charAt(4)-'0';
        //System.out.println(startC + " "+ startR + " "+ endC + " "+ endR);
        List<String> ans = new ArrayList<>();
        for(char c =startC;c<=endC;){
            for(int i=startR;i<=endR;i++){
                ans.add(c+""+i);
            }
            c= (char)(c+1);
        }
        return ans;
    }
}