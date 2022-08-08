// Recursion - TLE ❌
// TC: O(exponential)
// SC: O(n)
class Solution {
private:
    int MOD = 1e9 + 7;
    
    long helper(int i, int j) {
        // i = length of the string 
        // j = string ending with the j'th vowel
        
        // base case
        if (i == 0) {
            return 1;
        }
        
        long temp = 0;
        
        if (j == 0) {   // 'a'
            temp += helper(i - 1, 1);   // 'e'
        } else if (j == 1) {    // 'e'
            temp += helper(i - 1, 0);   // 'a'
            temp += helper(i - 1, 2);   // 'i'
        } else if (j == 2) {    // 'i'
            temp += helper(i - 1, 0);   // 'a'
            temp += helper(i - 1, 1);   // 'e'
            temp += helper(i - 1, 3);   // 'o'
            temp += helper(i - 1, 4);   // 'u'
        } else if (j == 3) {    // 'o'
            temp += helper(i - 1, 2);   // 'i'
            temp += helper(i - 1, 4);   // 'u'
        } else if (j == 4) {    // 'u'
            temp += helper(i - 1, 0);   // 'a'
        }

        return temp % MOD;
    }
    
public:
    int countVowelPermutation(int n) {
        int noOfVowels = 5;
        long count = 0;
        
        // 0 -> a
        // 1 -> e
        // 2 -> i
        // 3 -> o
        // 4 -> u
        
        for (int j = 0; j < noOfVowels; j++) {
            count += helper(n - 1, j);
        }
        
        return count % MOD;
    }
};


// Memoization - Accepted ✔
// TC: O(n * 5)
// SC: O(n * 5) + O(n) -> dp array + auxilary stack space
class Solution {
private:
    int MOD = 1e9 + 7;
    
    long helper(int i, int j, vector<vector<long>>& dp) {
        // i = length of the string 
        // j = string ending with the j'th vowel
        
        // base case
        if (i == 0) {
            return 1;
        }
        
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        
        long temp = 0;
        
        if (j == 0) {   // 'a'
            temp += helper(i - 1, 1, dp);   // 'e'
        } else if (j == 1) {    // 'e'
            temp += helper(i - 1, 0, dp);   // 'a'
            temp += helper(i - 1, 2, dp);   // 'i'
        } else if (j == 2) {    // 'i'
            temp += helper(i - 1, 0, dp);   // 'a'
            temp += helper(i - 1, 1, dp);   // 'e'
            temp += helper(i - 1, 3, dp);   // 'o'
            temp += helper(i - 1, 4, dp);   // 'u'
        } else if (j == 3) {    // 'o'
            temp += helper(i - 1, 2, dp);   // 'i'
            temp += helper(i - 1, 4, dp);   // 'u'
        } else if (j == 4) {    // 'u'
            temp += helper(i - 1, 0, dp);   // 'a'
        }
        
        return dp[i][j] = temp % MOD;
    }
    
public:
    int countVowelPermutation(int n) {
        int noOfVowels = 5;
        long count = 0;
        
        // 0 -> a
        // 1 -> e
        // 2 -> i
        // 3 -> o
        // 4 -> u

        vector<vector<long>> dp(n, vector<long>(noOfVowels, -1));
        
        for (int j = 0; j < noOfVowels; j++) {
            count += helper(n - 1, j, dp);
        }
        
        return count % MOD;
    }
};


// Tabulation - Accepted ✔
// TC: O(n * 5)
// SC: O(n * 5)
class Solution {
private:
    int MOD = 1e9 + 7;    
    
public:
    int countVowelPermutation(int n) {
        int noOfVowels = 5;
        long count = 0;
        
        // 0 -> a
        // 1 -> e
        // 2 -> i
        // 3 -> o
        // 4 -> u
        
        vector<vector<long>> dp(n, vector<long>(noOfVowels, -1));
        
        // base case
        for (int j = 0; j < noOfVowels; j++) {
            dp[0][j] = 1;
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < noOfVowels; j++) {
                long temp = 0;
        
                if (j == 0) {   // 'a'
                    temp += dp[i - 1][1];   // 'e'
                } else if (j == 1) {    // 'e'
                    temp += dp[i - 1][0];   // 'a'
                    temp += dp[i - 1][2];   // 'i'
                } else if (j == 2) {    // 'i'
                    temp += dp[i - 1][0];   // 'a'
                    temp += dp[i - 1][1];   // 'e'
                    temp += dp[i - 1][3];   // 'o'
                    temp += dp[i - 1][4];   // 'u'
                } else if (j == 3) {    // 'o'
                    temp += dp[i - 1][2];   // 'i'
                    temp += dp[i - 1][4];   // 'u'
                } else if (j == 4) {    // 'u'
                    temp += dp[i - 1][0];   // 'a'
                }

                dp[i][j] = temp % MOD;
            }
        }
        
        for (int j = 0; j < noOfVowels; j++) {
            count += dp[n - 1][j];
        }
        
        return count % MOD;
    }
};


// Tabulation + Space Optimization - Accepted ✔
// TC: O(n * 5)
// SC: O(2 * 5) ~ O(1)
class Solution {
private:
    int MOD = 1e9 + 7;    
    
public:
    int countVowelPermutation(int n) {
        int noOfVowels = 5;
        long count = 0;
        
        // 0 -> a
        // 1 -> e
        // 2 -> i
        // 3 -> o
        // 4 -> u
        
        vector<long> prev(noOfVowels, 0);
        vector<long> curr(noOfVowels, 0);
        
        // base case
        for (int j = 0; j < noOfVowels; j++) {
            prev[j] = 1;
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < noOfVowels; j++) {
                long temp = 0;
        
                if (j == 0) {   // 'a'
                    temp += prev[1];   // 'e'
                } else if (j == 1) {    // 'e'
                    temp += prev[0];   // 'a'
                    temp += prev[2];   // 'i'
                } else if (j == 2) {    // 'i'
                    temp += prev[0];   // 'a'
                    temp += prev[1];   // 'e'
                    temp += prev[3];   // 'o'
                    temp += prev[4];   // 'u'
                } else if (j == 3) {    // 'o'
                    temp += prev[2];   // 'i'
                    temp += prev[4];   // 'u'
                } else if (j == 4) {    // 'u'
                    temp += prev[0];   // 'a'
                }

                curr[j] = temp % MOD;
            }
            prev = curr;
        }
        
        for (int j = 0; j < noOfVowels; j++) {
            count += prev[j];
        }
        
        return count % MOD;
    }
};
