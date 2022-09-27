// @saorav21994

class Solution {
    
    public void fillup(char []ch, char lastchar, int lastpos, int idx, char dom) {
        // L...L -> fill all L
        // R...R -> fill all R
        // L...R -> invalid won't come here (do nothing)
        // R...L -> half R half L, odd -> ('.' in middle)
        // System.out.println("lastchar = " + lastchar + " dom = " + dom);
        if (lastchar == dom) {  // L...L || R...R
            for (int i = lastpos; i < idx; i++) {
                ch[i] = dom;
            }
        }   // R...L
        else {
            int trav = idx-lastpos-1;
            // System.out.println("trav = " + trav);
            int half = trav/2;
            for (int i = lastpos+1; i < lastpos+1+half; i++) {
                ch[i] = 'R';
            }
            for (int i = lastpos+1+half; i < idx ; i++) {
                ch[i] = 'L';
            }
            if (trav%2 == 1) {  // odd set middle to '.'
                ch[lastpos+1+half] = '.';
            }
        }
        // System.out.println("fillup function");
        // for (char c : ch) {
        //     System.out.print(c);
        // }
        // System.out.println();
    }
    
    public String pushDominoes(String dominoes) {
        // left -> right
        int l = dominoes.length();
        char [] ch = new char[l];
        
        char lastchar = '#';
        int lastpos = -1;
        for (int i = 0; i < l; i++) {
            char dom = dominoes.charAt(i);
            ch[i] = dom;
            if (dom == '.') {
                // leave it. do nothing as of now.
            }
            else if (dom == 'L') {
                if (lastchar == '#') {  // first character encountered
                    lastpos = 0;
                    lastchar = 'L';
                }
                // System.out.println("lastchar = " + lastchar + " lastpos = " + lastpos);
                fillup(ch, lastchar, lastpos, i, dom);
                lastpos = i;
                lastchar = dom;
            }
            else {  // dom = 'R'
                if (lastchar == '#') {  // first character encountered
                    lastpos = i;    // left to tight 'R' -> won't change left
                    lastchar = 'R';
                }
                if (lastchar == 'L') {  // Do nothing as no force exist
                    lastpos = i;
                    lastchar = dom;
                    continue;
                }
                fillup(ch, lastchar, lastpos, i, dom);
                lastpos = i;
                lastchar = dom;
            }
            // System.out.println("ch[i] = " + ch[i]);
        }
        // check if last char is 'R' and there are '.''s left. Fill them up as 'R'
        if (lastchar == 'R') {
            for (int i = lastpos; i < l; i++) {
                ch[i] = 'R';
            }
        }
        // for (char c : ch) {
        //     System.out.print(c);
        // }
        return new String(ch);
    }
}
