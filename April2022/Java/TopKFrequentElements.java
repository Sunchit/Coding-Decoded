
// @saorav21994
// TC : O(n)
// SC : O(n)

// countMap -> contains count of each element; revMap -> contains current set of elements for each count; hash[] -> contains the number of elements corresponding to a count

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int [] res = new int[k];
        HashMap<Integer, Integer> countMap = new HashMap<>();
        HashMap<Integer, Set<Integer>> revMap = new HashMap<>();
        int [] hash = new int[100001];
        
        for (int n : nums) {
            countMap.put(n, countMap.getOrDefault(n, 0) + 1);
            Set<Integer> cur = revMap.get(countMap.get(n));
            if (cur == null) {
                cur = new HashSet<>();
            }
            cur.add(n);
            revMap.put(countMap.get(n), cur);
            int curFreq = countMap.get(n);
            int prevFreq = curFreq -1;
            if (prevFreq > 0) {
                hash[prevFreq] -= 1;
                Set<Integer> pset = revMap.get(prevFreq);
                pset.remove(n);
                revMap.put(prevFreq, pset);
            }
            hash[curFreq] += 1;
            
        }
        
        // for (int i : hash) {
        //     System.out.print(i + " ");
        // }
        
        // for (Map.Entry<Integer, ArrayList<Integer>> entry : revMap.entrySet()) {
        //     ArrayList cur = entry.getValue();
        //     System.out.print(entry.getKey() + " : ");
        //     System.out.print(cur);
        //     System.out.println();
        // }
        
        int j = 0;
        for (int i = hash.length-1; i > 0; i--) {
            if (hash[i] == 0)
                continue;
            if (hash[i] > 0) {
                List<Integer> cur = new ArrayList<>(revMap.get(i));
                // Set<Integer> cur = revMap.get(i);
                int itr = 0;
                while (k > 0 && itr < cur.size()) {
                    res[j] = cur.get(itr);
                    itr += 1;
                    j += 1;
                    k -= 1;
                }
            }
            if (k == 0)
                break;
        }
        return res;
    }
}
