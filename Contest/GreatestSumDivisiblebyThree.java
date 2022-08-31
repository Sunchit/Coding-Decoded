// https://leetcode.com/problems/greatest-sum-divisible-by-three/
// @author: anuj0503
class Solution {
    public int maxSumDivThree(int[] nums) {
        Arrays.sort(nums);

        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        map.put(1, new PriorityQueue<>((a, b) -> (b - a)));
        map.put(2, new PriorityQueue<>((a, b) -> (b - a)));

        int sum = 0, m = 3;

        for(int num : nums){
            sum += num;

            if(num%m != 0){
                PriorityQueue<Integer> pq = map.get(num%m);
                pq.add(num);
                if(pq.size() > 2) pq.poll();

                map.put(num%m, pq);
            }
        }

        if(sum%3 == 0) return sum;

        int remainder = sum%3;

        int b = 0;
        if(map.get(m - remainder).size() == 2){
            PriorityQueue<Integer> pq = map.get(m - remainder);
            while(!pq.isEmpty()) b += pq.poll();
        }

        int a = 0;
        if(map.get(remainder).size() == 0) return sum - b;

        PriorityQueue<Integer> pq = map.get(remainder);
        while (pq.size() > 1) pq.poll();

        a = pq.poll();

        if(b > 0) a = Math.min(a, b);
        return sum - a;
    }
}
