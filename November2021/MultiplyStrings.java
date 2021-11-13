class Solution {

	public String multiply(String num1, String num2) {

		int m = num1.length();
		int n = num2.length();

		// Base Conditions
		if (m == 0 || n == 0 || "0".equals(num1) || "0".equals(num2)) {
			return "0";
		}
		if ("1".equals(num1)) {
			return num2;
		}
		if ("1".equals(num2)) {
			return num1;
		}

		// Result can be maximum of length M + N.
		// For example 99 * 999 = 98901 (Result is of length 5)
		int[] result = new int[m + n];

		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				// Adding previous values in result array into this product.
				product += result[i + j + 1];

				// Adding the new product into the result array
				result[i + j + 1] = product % 10;
				result[i + j] += product / 10;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int r : result) {
			if (sb.length() == 0 && r == 0) {
				continue;
			}
			sb.append(r);
		}

		return sb.toString();
	}

}