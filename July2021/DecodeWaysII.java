public class Solution {
  // TC : O(n)
  // SC : O(n)
  public int numDecodings(String s) {

    long[] dp = new long[s.length()+1];
    dp[0] = 1;
    dp[1] = decodeChar(s.charAt(0));

    for (int i=2; i<=s.length(); i++) {

      char prevChar = s.charAt(i-2);
      char currChar = s.charAt(i-1);

      // Single char decoding
      dp[i] += dp[i-1] * decodeChar(currChar);

      // Double char decoding
      dp[i] += dp[i-2] * decodeTwoChars(prevChar, currChar);

      dp[i] = dp[i]%1000000007;
    }
    return (int)dp[s.length()];
  }

  private int decodeChar(char c) {
    if (c == '*') {
      return 9;
    } else if (c == '0') {
      return 0;
    }
    return 1;
  }

  private int decodeTwoChars(char first, char second) {
    switch (first) {
      case '*':
        if (second == '*') {
          return 15;
        } else if (second >= '0' && second <= '6') {
          return 2;
        } else {
          return 1;
        }
      case '1':
        if (second == '*') {
          return 9;
        } else {
          return 1;
        }
      case '2':
        if (second == '*') {
          return 6;
        } else if (second >= '0' && second <= '6') {
          return 1;
        } else {
          return 0;
        }
      default:
        return 0;
    }
  }
}
