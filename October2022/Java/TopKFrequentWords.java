
// @saorav21994

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<String, Integer>> maxheap = new PriorityQueue<>((a,b) -> a.getValue() != b.getValue() ? b.getValue()-a.getValue() : a.getKey().compareTo(b.getKey()));
        for(String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        maxheap.addAll(map.entrySet());     // add all content of map to maxheap
        List<String> res = new ArrayList<>();
        while (k > 0) {
            Map.Entry<String, Integer> entry = maxheap.poll();
            res.add(entry.getKey());
            k -= 1;
        }
        return res;
    }
}
