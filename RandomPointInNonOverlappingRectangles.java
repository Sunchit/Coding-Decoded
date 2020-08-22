class RandomPointInNonOverlappingRectangles {

    Random rand = null;
    TreeMap<Integer, Integer> map = null;
    int[][] rects ;
    int area;
    public Solution(int[][] rects) {

        rand = new Random();
        map = new TreeMap<>();
        this.rects = rects;
        for(int i=0;i<rects.length;i++){
            // Calculate the current Area
            int currArea = (rects[i][2] - rects[i][0] +1) * (rects[i][3] - rects[i][1] +1);
            area += currArea;
            map.put(area, i); // cummulative sum vs id in rect
        }
    }

    public int[] pick() {
        int randInt = rand.nextInt(area); // Pick a random index
        int index = map.higherKey(randInt); // find its higher Key in map
        int[] rectChoosen = rects[map.get(index)]; // select a rectangle

        // Choose the points in that rectangle
        int x = rectChoosen[0] + (index - randInt -1) % (rectChoosen[2]- rectChoosen[0] +1);

        int y = rectChoosen[1] + (index - randInt -1) / (rectChoosen[2]- rectChoosen[0] +1);

        return new int[]{x, y};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */