// https://leetcode.com/problems/construct-smallest-number-from-di-string/
// @author: @anuj0503
class Solution {
    String result;
    public String smallestNumber(String pattern) {
        int n = pattern.length();

        char[] s = new char[n+1];

        for(int i = 0; i <= n; i++){
            s[i] = (char)(i + 1 + '0');
        }

        ArrayList<Character> permutation = new ArrayList<>();
        boolean[] visited = new boolean[n+1];

        getPermutationAndCheckPattern(permutation, s, pattern, visited);

        return result;
    }

    private boolean getPermutationAndCheckPattern(ArrayList<Character> permutation, char[] s, String pattern, boolean[] visited){
        if(permutation.size() == s.length){
            if(isPatternFound(pattern, permutation)){
                result = getString(permutation);
                return true;
            } else {
                return false;
            }
        }

        for(int i = 0; i < s.length; i++){
            if(!visited[i]){
                permutation.add(s[i]);
                visited[i] = true;
                if(getPermutationAndCheckPattern(permutation, s, pattern, visited)) return true;
                visited[i] = false;
                permutation.remove(permutation.size() - 1);
            }
        }
        
        return false;
    }
    
    private boolean isPatternFound(String pattern, ArrayList<Character> permutation){
        for(int i = 0; i < pattern.length(); i++){
            if(pattern.charAt(i) == 'I' && permutation.get(i + 1) < permutation.get(i)){
                return false;
            }
            
            if(pattern.charAt(i) == 'D' && permutation.get(i + 1) > permutation.get(i)){
                return false;
            }
        }
        return true;
    }
    
    private String getString(ArrayList<Character> al){
        StringBuilder sb = new StringBuilder();
        for(Character ch : al){
            sb.append(ch);
        }
        
        return sb.toString();
    }
}
