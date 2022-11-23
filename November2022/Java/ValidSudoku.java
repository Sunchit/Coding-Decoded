// @saorav21994

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch == '.') 
                    continue;
                if (set.contains(ch+"R"+i) || set.contains(ch+"C"+j) || set.contains(ch+"B"+i/3+"-"+j/3))
                    return false;
                else  {
                    set.add(ch+"R"+i);
                    set.add(ch+"C"+j);
                    set.add(ch+"B"+i/3+"-"+j/3);
                }
            }
        }
        return true;
    }
}
