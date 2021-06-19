class LongestPalindrome {
    public int longestPalindrome(String s) {
        int[] freq = new int[256];
        for(int el : s.toCharArray()){
            freq[el]++;
        }

        int count =0;
        int odd = 0;
        for(int el: freq){
            count += (2*(el/2));
            if(el%2==1){
                odd =1;
            }
        }

        return count+ odd;
    }
}