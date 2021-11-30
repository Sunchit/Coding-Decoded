class Solution {
	// TC : O(R*C)
	// SC : O(C)
	public int maximalRectangle(char[][] matrix) {
		if(matrix.length == 0)  return 0;
		int maxArea = 0;
		int row = matrix.length;
		int col = matrix[0].length;
		int[] dp = new int[col];
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				dp[j] = matrix[i][j] == '1' ? dp[j]+1 : 0;
			}
			//treating dp[j] as histogram, solving max area problem there and updating the max area
			maxArea = Math.max(maxArea, largestRectangleArea(dp));
		}
		return maxArea;
	}

	private int largestRectangleArea(int[] heights) {
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