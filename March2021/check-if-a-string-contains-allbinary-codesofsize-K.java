class Solution {

    // TC : O((n-k)*k)
    // SC : O(2^k)
    public boolean hasAllCodes(String s, int k) {
        if(s.length() < k){
            return false;
        }

        HashSet<String> set = new HashSet<>();

        for(int i=0;i<=s.length() - k ;i++){

            set.add(s.substring(i, i+k));
        }

        return set.size() == (Math.pow(2, k));
    }
}