class Solution {
	public List<Integer> replaceNonCoprimes(int[] nums) {
		LinkedList<Integer> res = new LinkedList();
		for (int el : nums) {
			while (true) {
				int last = res.isEmpty() ? 1 : res.getLast();
				int gcd = gcd(last, el);
				if (gcd == 1) break; // co-prime
				el *= (res.removeLast()) / gcd; // (el * lastEl)/GCD
			}
			res.add(el);
		}
		return res;
	}

	private int gcd(int a, int b) {
		return b > 0 ? gcd(b, a % b) : a;
	}
}