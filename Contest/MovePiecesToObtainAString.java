// https://leetcode.com/problems/move-pieces-to-obtain-a-string/
// @author: anuj0503
class Solution { 
    public boolean canChange(String s, String t) { 
        int count = 0; 
        
        //Checking if equal number of spaces
        for (char c : s.toCharArray()) { 
            if (c == '_')
                count++; 
        } 
        
        for (char c : t.toCharArray()) { 
            if (c == '_')
                count--;
        } 
        
        if (count != 0)
            return false;
        
        return checkIfEqualStringFormed(s, t); 
    } 
     
    public boolean checkIfEqualStringFormed(String s1, String s2) {
        // Checking if frequency of 'L and 'R' are equal in both string or not.
        int[] freq1 = new int[2];
        int[] freq2 = new int[2];
        
        for (int i = 0; i < s1.length(); i++) { 
            char s1c = s1.charAt(i); 
            char s2c = s2.charAt(i);
            
            if (s1c == 'L'){
                freq1[0]++;
            }
            else if(s1c == 'R'){
                freq1[1]++;
            } 
            if (s2c == 'L'){
                freq2[0]++;
            } 
            else if(s2c == 'R'){
                freq2[1]++;
            } 
        } 
         
        if(freq1[0] != freq2[0] || freq1[1] != freq2[1])
            return false;
        
        // List to store the indices of 'L' and 'R'.
        List<Integer> start = new ArrayList<>(); 
        List<Integer> target = new ArrayList<>(); 
         
        for (int i = 0; i < s1.length(); i++) { 
            if (s1.charAt(i) != '_') { 
                start.add(i); 
            } 
            if (s2.charAt(i) != '_') { 
                target.add(i); 
            } 
        }
        
        
        for (int i = 0; i < start.size(); i++) {
            // Checking if both string will be equal if we remove '_'
            if (s1.charAt(start.get(i)) != s2.charAt(target.get(i))) { 
                return false; 
            }
            
            // If character are same, check (negative case) 
            // if character at second string is behind first string character index.
            if (s1.charAt(start.get(i)) == 'L') { 
                if (start.get(i) < target.get(i)) { 
                    return false; 
                }
            } else {
                if (start.get(i) > target.get(i)) { 
                    return false; 
                } 
            } 
        } 
        return true; 
    } 
}


class Solution {
    // TC : O(n)
    // SC : O(1)
    public boolean canChange(String start, String target) {

        if (start.length() != target.length()) {
            return false;
        }

        int indexS = 0;
        int indexT = 0;

        while (indexS < start.length() || indexT < target.length()) {

            // skip all spaces in start
            while (indexS< start.length() && start.charAt(indexS) == '_') {
                indexS++;
            }

            // skip all spaces in target
            while (indexT < target.length() && target.charAt(indexT) == '_') {
                indexT++;
            }

            // if reached end
            if (indexT == target.length() && indexS == start.length()) {
                return true;
            }


            if (indexT == target.length()  || indexS == start.length() || start.charAt(indexS) != target.charAt(indexT)) {
                return false;
            }

            // if characters at both i and j are equal, check their relative positions in both start and target
            if (indexS < start.length()  && indexT < target.length()) {
                if(target.charAt(indexT) == 'L' && indexS < indexT) {
                    return false;
                }

                if(target.charAt(indexT) == 'R' && indexS > indexT) {
                    return false;
                }
            }

            indexS++;
            indexT++;
        }

        return true;
    }
}