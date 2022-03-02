// @saorav21994
// TC : O(length of t)
// SC : O(1)

class Solution {
    public boolean isSubsequence(String s, String t) {
        int ls = s.length();
        int lt = t.length();
        
        int i = 0, j = 0;
        
        while (i < ls) {
            char chs = s.charAt(i);
            boolean match = false;
            while (j < lt && chs != t.charAt(j)) {
                j += 1;
            }
            
            if (j >= lt && i < ls)
                return false;
            j += 1;
            i += 1;
            
        }
        return true;
    }
}


class Solution {
    // TC : O(len(s + T))
    // SC : O(1)
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0){
            return true;
        }
        int i = 0;
        int j = 0;
        while(j<t.length() && i<s.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }

        return i == s.length();
    }
}

// Author : @romitdutta10
// TC : O(len(s + t))
// SC : O(1)
// Problem : https://leetcode.com/problems/is-subsequence/
class Solution {
    public boolean isSubsequence(String s, String t) {
        int n = s.length();
        
        if(n > t.length()) {
            return false;
        }
        
        
        if(s == null || s.length() == 0) {
            return true;
        }
        int index = 0;
        
        
        
        
        for(char c : t.toCharArray()) {
            if(c == s.charAt(index)) {
                index++;
                
                if(index == n) {
                    return true;
                }
            }
            
        }
        
        return false;
    }
}

// Author : @romitdutta10
// TC : O(len(s + t))
// SC : O(1)
// Problem : https://leetcode.com/problems/is-subsequence/
// Another interesting approach but space and time complexity remains same
class Solution {
	public boolean isSubsequence(String s, String t) {
		for (char ch : s.toCharArray()) {
			int find = t.indexOf(ch);
			if (find == -1) {
				return false;
			} else {
				t = t.substring(find + 1);
			}
		}

		return true;
	}
}
