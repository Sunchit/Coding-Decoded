class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // el, next greater el
        Map<Integer, Integer> map = new HashMap<>();
        // el
        Stack<Integer> stack = new Stack<>();
        for (int el : nums2) {
            while (!stack.isEmpty() && stack.peek() < el){
                map.put(stack.pop(), el);
            }
            stack.push(el);
        }
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.getOrDefault(nums1[i], -1);
        }
        return ans;
    }
}