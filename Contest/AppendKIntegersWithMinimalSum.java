class Solution {


//     public long minimalKSum(int[] nums, int k) {
//         Set<Integer> set = new HashSet<>();
//         for(int el: nums){
//             set.add(el);
//         }

//         int i=1;
//         int ans = 0;

//         while(k>0){
//             if(!set.contains(i)){
//                 ans = ans+i;
//                 set.add(i);
//                 k--;
//             }
//                 i++;

//         }
//         return ans;
//     }


	public long minimalKSum(int[] nums, int k) {
		long ans =(long)k * (k + 1)/2;

		Set<Integer> set = new HashSet<>();

		int count= 0;

		for(int num : nums){
			if(!set.contains(num) && num <=k && num >= 1){
				ans = ans - (long) num;
				count++;
			}
			set.add(num);
		}


		int i =k+1;
		while(count>0){
			if(!set.contains(i)){
				ans += i;
				count--;
			}
			i++;
		}

		return ans;
	}
}