
public class Array10 {

    public static int trappedRainWater(int height[]){
        int leftMax[] = new int[height.length];
        leftMax[0] = height[0];

        for(int i=1;i<height.length;i++){
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }
        int rightMax[] = new int[height.length];
        rightMax[height.length-1] = height[height.length-1];
        for(int i=height.length-1;i>0;i--){
            rightMax[i] = Math.max(height[i], rightMax[i+1]);

        }

        int trappedRainWater = 0;
        for(int i=0;i<height.length;i++){
            int waterlevel = Math.max(height[i], rightMax[i+1]);
            trappedRainWater+=waterlevel-height[i];
        }

        return trappedRainWater;
    }

    public static void main(String[] args) {
        int height[] = {4,2,0,6,3,2,5};
        System.out.println(trappedRainWater(height));
    }
}
