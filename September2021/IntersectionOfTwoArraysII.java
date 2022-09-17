class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] freq1 = getFreq(nums1);
        int[] freq2 = getFreq(nums2);


        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<freq1.length;i++){
            int count = Math.min(freq1[i], freq2[i]);
            while(count-->0){
                ans.add(i);
            }
        }


        int[] res = new int[ans.size()];

        for(int i=0;i<ans.size();i++){
            res[i] = ans.get(i);
        }
        return res;
    }

    private int[] getFreq(int[] nums){
        int[] freq = new int[1001];
        for(int el: nums){
            freq[el]++;
        }
        return freq;
    }
}