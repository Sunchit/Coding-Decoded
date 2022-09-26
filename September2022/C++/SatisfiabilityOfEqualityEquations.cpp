// https://leetcode.com/problems/satisfiability-of-equality-equations/
// inspired by @saorav21994's Java Solution
class Solution {
private:
    int getParent(int index, vector<int>& parent) {
        if (parent[index] == index) {
            return index;
        }
        return getParent(parent[index], parent);
    }
    
public:
	  // TC: O(n)
	  // SC: O(1)
    bool equationsPossible(vector<string>& equations) {
        // If a == b, then a's parent = a and b's parent = a
        // then if b == c, then since b's parent = a, then c's parent = a

        // We build the parent using Union Find

        // When we travel all != cases, if var1, var2 parent are same, but they have != relationship,
        // this is not possible return false
        // else return true

        vector<int> parent(26, 0);
        for (int i = 0; i < 26; i++) {
            parent[i] = i;  // initially all are their own parent
        }

        // first traverse all == cases to establish parent-child relationship
        for (auto equation : equations) {
            if (equation[1] == '=') {
                int var1 = getParent(equation[0] - 'a', parent);
                int var2 = getParent(equation[3] - 'a', parent);

                if (var1 != var2) {
                    parent[var2] = var1;
                }
            }
        }

        // now traverse all != cases to check if any invalid equation exist
        for (auto equation : equations) {
            if (equation[1] == '!') {
                int var1 = getParent(equation[0] - 'a', parent);
                int var2 = getParent(equation[3] - 'a', parent);

                if (var1 == var2) {
                    return false;
                }
            }
        }

        return true;
    }
};
