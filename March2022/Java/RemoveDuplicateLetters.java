
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
