class Solution {

    // TC :O(n2)
    // SC : O(n)
    public int threeSumMulti(int[] arr, int target) {
        Map<Integer, Long> freqMap = new HashMap<>();
        for(int el: arr){
            long freq = freqMap.getOrDefault(el, 0l);
            freqMap.put(el, freq+1l);
        }

        long ans =0;
        for(Integer el1: freqMap.keySet()){
            for(Integer el2 : freqMap.keySet()){
                int el3 = target -el1 -el2;
                if(freqMap.containsKey(el3)){
                    long freq1 = freqMap.get(el1);
                    long freq2 = freqMap.get(el2);
                    long freq3 = freqMap.get(el3);

                    if(el1 == el2 && el1 ==el3){
                        ans += ((freq1) * (freq1-1)*(freq1-2))/6;
                    } else if(el1 ==el2 && el1!=el3){
                        ans += ((freq1)*(freq1-1))/2 *freq3;
                    } else if(el1< el2 && el2<el3){
                        ans += ((freq1*freq2 *freq3));
                    }

                }
                ans = ans % 1000000007;
            }
        }
        return (int) ans;
    }
}