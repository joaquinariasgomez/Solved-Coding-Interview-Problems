public class ContainerWithMostWater {

    public int getMostWaterArea(int[] heights) {
        int maxArea = 0;

        int begin = 0;
        int end = heights.length-1;
        while(begin < end) {
            int currArea = (end - begin) * Math.min(heights[begin], heights[end]);
            maxArea = Math.max(maxArea, currArea);
            if(heights[begin] < heights[end]) {
                begin++;
            }
            else {
                end--;
            }
        }
        return maxArea;
    }

    public void run() {
        int[] heights = {1,8,6,2,5,4,8,3,7};
        System.out.println(getMostWaterArea(heights));
    }
    public static void main(String[] args) {
        new ContainerWithMostWater().run();
    }
}