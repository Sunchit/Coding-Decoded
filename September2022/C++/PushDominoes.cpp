// https://leetcode.com/problems/push-dominoes/
class Solution {
public:
    // TC: O(n)
    // SC: O(2 * n)
    string pushDominoes(string dominoes) {
        int n = dominoes.length();

        vector<int> left(n, 0);
        int i = n - 1;
        while (i >= 0) {
            while (i >= 0 && dominoes[i] != 'L') {
                left[i] = -1;
                i--;
            }
            int index = i;
            while (i >= 0 && dominoes[i] != 'R') {
                if (dominoes[i] == 'L') {
                    index = i;
                }
                left[i] = index;
                i--;
            }
        }

        vector<int> right(n, 0);
        i = 0;
        while (i < n) {
            while (i < n && dominoes[i] != 'R') {
                right[i] = -1;
                i++;
            }
            int index = i;
            while (i < n && dominoes[i] != 'L') {
                if (dominoes[i] == 'R') {
                    index = i;
                }
                right[i] = index;
                i++;
            }
        }

        string ans = "";
        for (i = 0; i < n; i++) {
            if (dominoes[i] == '.') {
                int nearestLeft = left[i];
                int nearestRight = right[i];

                int leftDist = nearestLeft == -1 ? INT_MAX : abs(nearestLeft - i);
                int rightDist = nearestRight == -1 ? INT_MAX : abs(nearestRight - i);

                if (leftDist < rightDist) {
                    ans += 'L';
                } else if (leftDist > rightDist) {
                    ans += 'R';
                } else {
                    ans += '.';
                }
            } else {
                ans += dominoes[i];
            }
        }

        return ans;        
    }
};
