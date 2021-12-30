class Solution {
public: 
    int smallestRepunitDivByK(int K) {
        for (int r = 0, N = 1; N <= K; ++N)
            if ((r = (r * 10 + 1) % K) == 0)
                return N;
        return -1;
    }
};
