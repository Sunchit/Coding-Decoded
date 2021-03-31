class Solution {
    public int[] movesToStamp(String stamp, String target) {
        List<Integer> reverseIndexList = new ArrayList<>();
        int len = target.length();
        char[] curr = target.toCharArray();
        char[] targetStr = new char[len];
        Arrays.fill(targetStr, '*');

        while(!Arrays.equals(curr, targetStr)){
            int stampIndex = fetchStampIndex(curr, stamp);
            System.out.println(stampIndex);
            if(stampIndex<0){
                return new int[0];
            } else {
                update(curr, stampIndex, stamp);
            }
            reverseIndexList.add(stampIndex);
        }

        int[] ans = new int[reverseIndexList.size()];

        for(int i=0;i<reverseIndexList.size();i++){
            ans[i] = reverseIndexList.get(reverseIndexList.size()-1-i);
        }
        return ans;
    }

    private int fetchStampIndex(char[] curr, String stamp){
        System.out.println( new String(curr));

        for(int i=0;i<=curr.length - stamp.length();i++){
            int j=0;
            int s = i;
            boolean isNonStarChar = false;

            while(j<stamp.length() && s<curr.length && (curr[s] == '*' || (curr[s] == stamp.charAt(j)))) {
                if(curr[s] !='*'){
                    isNonStarChar = true; /// ******** , ab
                }
                s++;
                j++;


            }

            if(j == stamp.length() && isNonStarChar){
                return i;
            }
        }
        return -1;
    }

    private void update(char[] curr, int i, String stamp){
        for(int j=0;j<stamp.length();j++){
            curr[j+i] = '*';
        }
    }



}