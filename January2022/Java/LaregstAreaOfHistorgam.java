class Solution {

    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0)
            return 0;
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> stack = new Stack<>();
        //using the stack to find the last number which smaller than heights[i]
        for(int i=0; i<n; i++) {
            while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear();
        //using the stack to find the next number which smaller than heights[i]
        for(int i=n-1; i>=0; i--) {
            while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                right[i] = n;
            } else {
                right[i] = stack.peek();
            }
            stack.push(i);
        }


        int maxArea = 0;
        for(int i=0; i<n; i++) {
            int area = (right[i] - left[i] - 1) * heights[i];
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}