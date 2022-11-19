// @saorav21994

class Solution {
    public int[][] outerTrees(int[][] trees) {
        // slope = ((x2-x1)/(y2-y1)) = ((x1-x)/(y1-y))
        // we need to form convex polygon
        // see convex hull problem for further coverage
        
        if (trees.length == 1)
            return trees;
        
        List<Point> points = new ArrayList<>();
        for (int [] tree : trees) {
            points.add(new Point(tree[0], tree[1]));
        }
        
        int n = points.size();
        List<Point> res = new ArrayList<>();
        
        // Sort ascending based on ordinate (for equal case sort on abscissa)
        Collections.sort(points, (a,b) -> a.y==b.y ? a.x-b.x : a.y-b.y);
        
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        
        Stack<Point> hull = new Stack<>();
        
        // push first 2 point
        hull.push(points.get(0));
        hull.push(points.get(1));
        
        // lower hull
        for (int i = 2; i < n; i++) {
            Point tos = hull.pop();
            while (hull.isEmpty() == false && counterClockWise(hull.peek(), tos, points.get(i)) < 0) {
                tos = hull.pop(); // we need counter clock wise (to consider) ->  > 0
            }
            hull.push(tos);
            hull.push(points.get(i));
        }
        
        // upper hull -> take in descending array to maintain same counter clock wise logic
        for (int i = n-2; i >= 0; i--) {
            Point tos = hull.pop();
            while (hull.isEmpty() == false && counterClockWise(hull.peek(), tos, points.get(i)) < 0) {
                tos = hull.pop(); // we need counter clock wise (to consider) ->  > 0
            }
            hull.push(tos);
            hull.push(points.get(i));
        }
        
        // remove the duplicate co-ordinates
        for  (Point p : hull) {
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.add(p.x);
            tmp.add(p.y);
            if (set.contains(tmp) == false) {
                set.add(tmp);
                res.add(p);
            }
        }
        
        // build the answer array and return
        int [][] fence = new int[res.size()][2];
        int i = 0;
        for (Point p : res) {
            fence[i][0] = p.x;
            fence[i][1] = p.y;
            i += 1;
        }
        
        return fence;
        
    }
    
    private class Point {
        int x;
        int y;
        public Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int counterClockWise(Point a, Point b, Point c) {
        double slope = (b.x-a.x)*(c.y-a.y) - (b.y-a.y)*(c.x-a.x);
        if (slope > 0)
            return 1;
        else if (slope < 0)
            return -1;
        else
            return 0;
    }
}
