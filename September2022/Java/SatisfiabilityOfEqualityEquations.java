
// @saorav21994

class Solution {
    public boolean equationsPossible(String[] equations) {
        
        // If a == b, then a's parent = a and b's parent = a; then if b == c, then since b's parent = a, then c'a parent = a.
        // We build the parent map using union-find.
        // Next when we traverse all != cases, if var1, var2 parent are same but they have != relationship, this is not possible -> return false
        // return true otherwise at end.
        
        int [] parent = new int[26];
        
        for (int i = 0; i < 26; i++) {
            parent[i] = i;      // initially all are their own parent
        }
        
        // first traverse all == cases to establish parent-child relationship
        for (String equation : equations) {
            char equality = equation.charAt(1);
            if (equality == '=') {
                
                int var1 = fetchParent(equation.charAt(0)-97, parent);
                int var2 = fetchParent(equation.charAt(3)-97, parent);
                
                if (var1 != var2) {     // unify them
                    parent[var2] = var1;
                }
                
            }
        }
        
        // for (int i = 0; i < 26; i++) {
        //     System.out.print(parent[i] + " ");
        // }
        // System.out.println();
        
        // now traverse all != cases to check if any invalid condition exist
        for (String equation : equations) {
            char equality = equation.charAt(1);
            if (equality == '!') {
                
                int var1 = fetchParent(equation.charAt(0)-97, parent);
                int var2 = fetchParent(equation.charAt(3)-97, parent);
                
                if (var1 == var2) {     
                    return false;
                }
                
            }
        }
        
        return true;
        
    }
    
    
    public int fetchParent(int index, int [] parent) {
        if (parent[index] == index)
            return index;
        return fetchParent(parent[index], parent);
    }
    
}
