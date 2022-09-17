class Solution {

    // TC : O(1) => O(9^2) => O(81)
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet();
        for (int i=0; i<9; ++i) {
            for (int j=0; j<9; ++j) {
                char number = board[i][j];
                if (number != '.')
                    if (seen.contains(number + "_R_" + i) ||
                            seen.contains(number + "_C_ " + j) ||
                            seen.contains(number + "_B_" + i/3 + "_" + j/3)) {

                        return false;
                    } else {
                        seen.add(number + "_R_" + i);
                        seen.add(number + "_C_ " + j);
                        seen.add(number + "_B_" + i/3 + "_" + j/3);
                    }

            }
        }
        return true;
    }
}