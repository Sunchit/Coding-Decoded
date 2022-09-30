// @saorav21994

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        int len = buildings.length;
        int [][] coor = new int[len*2][2];
        for (int i = 0, j = 0; j < len; i++, j++) {
            coor[i][0] = buildings[j][0];
            coor[i][1] = -buildings[j][2];
            i += 1;
            coor[i][0] = buildings[j][1];
            coor[i][1] = buildings[j][2];
        }
        Arrays.sort(coor, (a,b)->(a[0] != b[0]) ? (a[0]-b[0]) : (a[1]-b[1]));
        // for (int [] a : coor) {
        //     System.out.println(a[0] + " " + a[1]);
        // }
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        int top = 0;
        maxheap.add(top);
        for (int []abscissa : coor) {
            // System.out.println("loop start macheap = " + maxheap.peek());
            if (abscissa[1] < 0) {  // left
                maxheap.offer(-abscissa[1]);
            }
            else {  // right
                maxheap.remove(abscissa[1]);
            }
            // System.out.println("loop end macheap = " + maxheap.peek());
            if (top != maxheap.peek()) {
                top = maxheap.peek();
                res.add(new ArrayList<Integer>(Arrays.asList(abscissa[0], top)));
            }
        }
        return res;
    }
}
