public class PeakIndexInMountainArrayv2 {
    public static void main(String[] args) {
        System.out.println("For [0,1,0], the answer is: " + peakIndexInMountainArray(new int[]{0, 1, 0}));
        System.out.println("For [0,2,1,0], the answer is: " + peakIndexInMountainArray(new int[]{0, 2, 1, 0}));
        System.out.println("For [0,1,2,3,4,5,3,1], the answer is: " + peakIndexInMountainArray(new int[]{0,1,2,3,4,5,3,1}));
    }

    public static int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] < arr[mid + 1]) {
                // We're in the increasing part → move right
                left = mid + 1;
            } else {
                // We're in the decreasing part (or at the peak)
                right = mid;
            }
        }
        // left == right is the peak index
        return left;
    }
}
