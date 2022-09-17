// class Solution {
//     public long[] getDistances(int[] arr) {
//         Map<Integer, Set<Integer>> map = new HashMap<>();
//         for(int i=0;i<arr.length;i++){
//             int el = arr[i];
//             Set<Integer> indices = map.getOrDefault(el, new HashSet<>());
//             indices.add(i);
//             map.put(el, indices);
//         }

//         long[] ans = new long[arr.length];

//         for(Map.Entry<Integer, Set<Integer>> entry : map.entrySet()){
//             Set<Integer> index = entry.getValue();

//             for(Integer i : index){
//                 long count = 0;
//                 for(Integer j : index){
//                     count += Math.abs(j-i);
//                 }
//                 ans[i] = count;
//             }
//         }
//         return ans;
//     }
// }

// TC : O(n)
// SC : O(n)
class Solution {
	public long[] getDistances(int[] arr) {
		long[] ans = new long[arr.length];
		// Value, Sum of Indices
		Map<Integer, Long> sum = new HashMap<>();
		int[] freq = new int[100001];
		for (int i = 0; i < arr.length; ++ i) {
			int el = arr[i];
			if (!sum.containsKey(el )) {
				sum.put(el , 0l);

			}

			ans[i] += i * (long)freq[el] - sum.get(el);
			sum.put(el, sum.get(el) + i);
			freq[el]++;

		}

		sum = new HashMap<>();
		freq = new int[100001];
		int len = arr.length;
		for (int i = len - 1; i >= 0;  i--) {
			if (!sum.containsKey(arr[i])) {
				sum.put(arr[i], 0l);

			}
			ans[i] += sum.get(arr[i]) - ( i) * (long)freq[arr[i]];
			sum.put(arr[i], sum.get(arr[i]) + i);
			freq[arr[i]]++;
		}

		return ans;
	}
}

