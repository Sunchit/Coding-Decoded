// https://leetcode.com/problems/number-of-common-factors/
// @author: anuj0503
class Solution {
    
    public int commonFactors(int a, int b) {
        Set<Integer> set1 = getDivisors(a);
        Set<Integer> set2 = getDivisors(b);
        
        int[] freq = new int[1001];
        
        for(int num : set1){
            freq[num]++;
        }
        
        for(int num : set2){
            freq[num]++;
        }
        
        int result = 0;
        for(int i = 1; i <= 1000; i++){
            if(freq[i] == 2){
                result++;
            }
        }
        
        return result;
    }

    private Set<Integer> getDivisors(int n)
    {
        Set<Integer> set = new HashSet<>();
        for (int i=1; i<=Math.sqrt(n); i++)
        {
            if (n%i==0)
            {
                if (n/i == i)
                    set.add(i);

                else {
                    set.add(i);
                    set.add(n / i);
                }
            }
        }

        return set;
    }
}
