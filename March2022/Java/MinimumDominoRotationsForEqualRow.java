// @saorav21994

/* My original solution */

class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        
        int [] ha = new int[6];
        int [] hb = new int[6];
        
        int [][] hia = new int[6][20000];
        int [][] hib = new int[6][20000];
        
        int l =  A.length;
        
        for (int i = 0; i < l; i++) {
            
            ha[A[i] - 1] += 1;
            hb[B[i] - 1] += 1;
            
            hia[A[i]-1][i] = 1;
            hib[B[i]-1][i] = 1;
            
        }
        
        int found = 0;
        int rot = Integer.MAX_VALUE;
        
        for (int i = 0; i < 6; i++) {
            if ((ha[i] == l) || (hb[i] == l)) {
                found = 1;
                rot = Math.min(rot, 0);
                break;
            }
            else if ((ha[i] + hb[i]) < l) {
                // Do nothing. Skip this iteration
            }
            else {
                // First process for A
                int tmp = 0;
                int fail = 0;
                for (int j = 0; j < l; j++) {
                    if (hia[i][j] == 0 && hib[i][j] == 1) {
                        tmp += 1;
                    }
                    else if (hia[i][j] == 0 && hib[i][j] == 0) {
                        tmp = Integer.MAX_VALUE;
                        fail = 1;
                        break;
                    }
                }
                if (fail == 0) {
                    rot = Math.min(rot, tmp);
                    found = 1;
                }
                tmp = 0;
                fail = 0;
                // Now process for B
                for (int j = 0; j < l; j++) {
                    if (hib[i][j] == 0 && hia[i][j] == 1) {
                        tmp += 1;
                    }
                    else if (hib[i][j] == 0 && hia[i][j] == 0) {
                        tmp = Integer.MAX_VALUE;
                        fail = 1;
                        break;
                    }
                }
                if (fail == 0) {
                    rot = Math.min(rot, tmp);
                    found = 1;
                }                
                
            }
        }
        if (found == 0) rot = -1;
        return rot;
        
    }
}


/* Simplified Solution as uploaded on youtube by Sunchit (Coding-Decoded) */

class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        
        int top = findValue(A, B, A[0]);
        int bottom = findValue(A, B, B[0]);
        
        if (top >= 0 && bottom >= 0) {
            return Math.min(top, bottom);
        }
        else if (top >= 0)
            return top;
        else
            return bottom;
        
    }
    
    
    public int findValue(int [] A, int [] B, int value) {
        int topCount = 0, bottomCount = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != value && B[i] != value)
                return -1;
            else if (A[i] == value && B[i] != value)
                bottomCount += 1;
            else if (A[i] != value && B[i] == value)
                topCount += 1;
                
        }
        return Math.min(topCount, bottomCount);
    }
}

// Author: @romitdutta10
// TC: O(N)
// SC: O(1)
// Problem : https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/

class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        
        int ans1 = conversionToTarget(tops, bottoms, tops[0]);
        int ans2 = conversionToTarget(tops, bottoms, bottoms[0]);
        
        if(ans1 > 0 && ans2 > 0) {
            return Math.min(ans1, ans2);
        } else if(ans1 > 0) {
            return ans1;
        } else return ans2;
    }
    
    private int conversionToTarget(int[] tops, int[] bottoms, int target) {
        int topConversion = 0;
        int bottomConversion = 0;
        
        for(int i=0; i<tops.length; i++) {
            if(tops[i] != target && bottoms[i] != target) {
                return -1;
            } else if(tops[i] != target) {
                topConversion++;
            } else if(bottoms[i] != target) {
                bottomConversion++;
            }
        }
        
        return Math.min(topConversion, bottomConversion);
    }
}
