class Solution {
	public int mirrorReflection(int p, int q) {
		while (p % 2 == 0 && q % 2 == 0) {
			p /= 2;
			q /= 2;
		}
		if(q%2==0 && p%2!=0) {
			return 0;
		}

		if(q%2!=0 && p%2==0) {
			return 2;
		}

		if(q%2!=0 && p%2!=0) {
			return 1;
		}

		return -1;
	}
}




// @saorav21994
// TC : O(log(max(p,q)))
// SC : O(1)

class Solution {
    public int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b%a, a);
    }
    public int mirrorReflection(int p, int q) {
        int g = gcd(p, q);
        p /= g;
        p %= 2;
        q /= g;
        q %= 2;
        if (p == 1 && q == 1) return 1;
        return p == 1 ? 0 : 2;
    }
}
