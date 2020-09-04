// Time complexity is O(n)
// Space complexity is O(1)
class PartitionLabels  {
    public List<Integer> partitionLabels(String S) {
        int[] indexLast = new int[26];

        // abca
        for(int i=0;i<S.length();i++){
            char c = S.charAt(i);
            int index = c -'a';
            indexLast[index] = i;
        }

        List<Integer> ans = new ArrayList<>();

        int lastIndex = -1;
        int start = 0;
        for(int i=0;i<S.length();i++){
            int currLastIndex = indexLast[S.charAt(i) - 'a'];
            lastIndex = Math.max(lastIndex, currLastIndex);
            if(lastIndex == i){

                ans.add(lastIndex +1 - start);
                start = lastIndex +1;
            }
        }

        return ans;


    }
}