class Solution {
	// TC : O(n)
	// SC : O(n)
	public int maximumsSplicedArray(int[] nums1, int[] nums2) {
		int n = nums1.length;
		int array1Major = 0;
		int array2Major = 0;

		int[] diff = new int[n];

		for(int i=0;i<n;i++){
			array1Major += nums1[i];
			array2Major += nums2[i];
		}

		// Treating array 1 major
		// More delta to be added in array 1 from array 2
		for(int i=0;i<n;i++){
			diff[i] = nums2[i]-nums1[i];
		}

		int max=0, cur=0;

		for (int el:diff){
			cur = Math.max(cur+el,el);
			max = Math.max(max, cur);
		}
		array1Major += max;

		// Treating array 2 major
		// More delta to be added in array 2 from array 1

		for(int i=0;i<n;i++){
			diff[i] = nums1[i]-nums2[i];
		}
		max=0; cur=0;
		for (int el:diff){
			cur= Math.max(cur+el,el);
			max=Math.max(max, cur);
		}
		array2Major += max;
		return Math.max(array1Major,array2Major);
	}
}