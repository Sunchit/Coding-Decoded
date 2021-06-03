class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {

        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        int hLength = horizontalCuts.length;
        int vLength = verticalCuts.length;

        int maxHeight = Math.max(horizontalCuts[0]-0, h - horizontalCuts[hLength-1]);
        for (int i = 1;i<hLength; i++){
            int horizatalWidth = horizontalCuts[i] - horizontalCuts[i-1];
            maxHeight = Math.max(maxHeight, horizatalWidth);
        }


        int maxWidth = Math.max(verticalCuts[0]-0, w - verticalCuts[vLength-1]);
        for (int i = 1;i<vLength; i++){
            int verticalWidth = verticalCuts[i] - verticalCuts[i-1];
            maxWidth = Math.max(maxWidth, verticalWidth);
        }

        long ans = 1L * maxHeight * maxWidth;

        return  (int) (ans % 1000000007);
    }
}