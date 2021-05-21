class Solution {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        String p = normalize(pattern);

        List<String> ans = new ArrayList<String>();
        for (String word : words)
            if (p.equals(normalize(word))) ans.add(word);
        return ans;
    }


    public String normalize(String str) {

        HashMap<Character, Integer> map = new HashMap<>();

        int len = str.length();

        String ans = "";

        for (int i = 0; i < len; i++) {
            map.putIfAbsent(str.charAt(i), map.size());
            ans += map.get(str.charAt(i));
        }

        return ans;
    }
}