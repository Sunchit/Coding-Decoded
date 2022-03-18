
// @saorav21994
// TC : O(n)
// SC : O(n)


class Solution {
    public String removeDuplicateLetters(String s) {
        int [] hash = new int[26];
        boolean [] visited = new boolean[26];
        Stack<Character> stack = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            int index = (int)ch-97;
            hash[index] += 1;
        }
        
        for (char ch : s.toCharArray()) {
            int index = (int)ch - 97;
            hash[index] -= 1;
            if (visited[index])
                continue;
            while (!stack.isEmpty() && ch < stack.peek() && hash[(int)stack.peek()-97] > 0) {
                visited[(int)stack.peek()-97] = false;
                stack.pop();
            }
            stack.push(ch);
            visited[index] = true;
            
        }
        
        StringBuilder sb = new StringBuilder();
        
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        
        return sb.toString();
        
    }
}

// Author: @romitdutta10
// TC: O(N)
// SC: O(N)
// Problem : https://leetcode.com/problems/remove-duplicate-letters/


class Solution {
    public String removeDuplicateLetters(String s) {
        boolean visited[] = new boolean[26];
        int lastSeen[] = new int[26];
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            lastSeen[c-'a'] = i;
        }
        
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            
            if(visited[c-'a']) {
                continue;
            }
            
            while(!stack.isEmpty() && stack.peek() > c && i< lastSeen[stack.peek()-'a']) {
                visited[stack.pop() - 'a'] = false;
            }
            
            stack.push(c);
            visited[c-'a'] = true;
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        
        return sb.toString();
        
        
    }
}
