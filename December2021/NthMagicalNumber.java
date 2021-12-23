class Solution {
	public int nthMagicalNumber(int n, int a, int b) {

		long A = a, B = b;
		long mod = (long)(Math.pow(10,9)+7);


		long left = Math.min(a,b), right = (long)n*Math.min(a,b);

		// Finding GCD
		while (B > 0) {
			long tmp = A;
			A = B;
			B = tmp % B;
		}

		long lcm = (a*b)/A;     //(n1*n2)/GCD

		while (left < right) {
			long m = left+(right-left)/2;

			if ((m / a) + (m / b) - (m / lcm) < n) left = m + 1;

			else right = m;
		}
		return (int)(left % mod);
	}
}