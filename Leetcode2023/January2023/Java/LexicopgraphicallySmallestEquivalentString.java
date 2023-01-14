// @saorav21994

class Solution {
    
    int [] map = new int[26];
    
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        
        // Implement a DSU
        
        for (int i = 0; i < 26; i++) {
            map[i] = i;
        }
        
        // group the alphabets
        
        int l = s1.length();
        for (int i = 0; i < l; i++) {
            int ch1 = s1.charAt(i)-'a';
            int ch2 = s2.charAt(i)-'a';
            union(ch1, ch2);
        }
        
        /*
        for (int x : map) {
            System.out.print(x+" ");
        }
        */
        
        StringBuffer sb = new StringBuffer();
        for (char ch : baseStr.toCharArray()) {
            sb.append((char)(find(map[ch-'a'])+97));
        }
        return sb.toString();
        
    }
    
    public void union(int u, int v) {
        u = find(u);
        v = find(v);
        
        if (u == v)
            return;
        map[Math.max(u,v)] = Math.min(u,v);
    }
    
    public int find(int x) {
        if (map[x] == -1)
            return map[x] = x;
        if (map[x] == x) 
            return x;
        return map[x] = find(map[x]);
    }
    
}
