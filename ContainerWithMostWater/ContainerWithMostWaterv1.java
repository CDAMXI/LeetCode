public class ContainerWithMostWaterv1{
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7})); // Output: 49
        System.out.println(maxArea(new int[]{1,1})); // Output: 1
    }

    public static int maxArea(int[] height){
        int area = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int minHeight = Math.min(height[left], height[right]);
            int width = right - left;
            area = Math.max(area, minHeight * width);
            
            // Move the pointer pointing to the shorter line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return area;
    }
}
