
     class Solution {
         public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
             Set<Integer> set1 = new HashSet<>();
             Set<Integer> set2 = new HashSet<>();

             for (int num : nums1)
                 set1.add(num);

             for (int num : nums2)
                 set2.add(num);

             List<Integer> el1 = new ArrayList<>();

             for (int num : set1)
                 if (!set2.contains(num)) el1.add(num);

             List<Integer> el2 = new ArrayList<>();

             for (int num : set2)
                 if (!set1.contains(num)) el2.add(num);

             return Arrays.asList(el1, el2);

         }
     }


class Solution {
	public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
		int[] freq1 = new int[2001];
		for(int el: nums1){
			freq1[el + 1000]++;
		}

		int[] freq2 = new int[2001];
		for(int el: nums2){
			freq2[el + 1000]++;
		}

		List<Integer> firstEl = new ArrayList<>();
		for(int el: nums1){
			if(freq2[el+1000] == 0) {
				if(!firstEl.contains(el)) {
					firstEl.add(el);
				}
			}
		}

		List<Integer> secondEl = new ArrayList<>();
		for(int el: nums2){
			if(freq1[el+1000] == 0){
				if(!secondEl.contains(el)) {
					secondEl.add(el);
				}
			}
		}

		List<List<Integer>> ans = new ArrayList<>();
		ans.add(firstEl);
		ans.add(secondEl);

		return ans;

	}
}
