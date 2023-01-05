// @saorav21994

class Solution {
    public int findMinArrowShots(int[][] points) {
        
        Arrays.sort(points, (a,b) -> Integer.compare(a[0], b[0]));
        
        // for (int [] point : points) {
        //     for (int p : point) {
        //         System.out.print(p + " ");
        //     }
        //     System.out.println();
        // }
        
        int cnt = 0;
        int left = points[0][0];
        int right = points[0][1];
        for (int [] point : points) {
            if (point[0] <= right) {
                left = point[0];
                right = Math.min(right, point[1]);
            }
            else {
                cnt += 1;
                left = point[0];
                right = point[1];
            }
        }
        
        return cnt+1;
    }
}
