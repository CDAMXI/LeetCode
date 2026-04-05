public class PeakIndexInMountainArrayv1{
    public static void main(String[] args) {
        System.out.println("For [0,1,0], the answer is: " + peakIndexInMountainArray(new int[]{0,1,0}));
        System.out.println("For [0,2,1,0], the answer is: " + peakIndexInMountainArray(new int[]{0,2,1,0}));
    }

    public static int peakIndexInMountainArray(int[] arr){
        if (arr.length == 0) {return -1;}
        if (arr.length == 1) {return 0;}
        if (arr.length == 2) {return arr[0] > arr[1] ? 0 : 1;}
        int max = 0;
        for (int i = 1; i < arr.length - 1; i++){
            if (arr[i] > arr[i-1] && arr[i] > arr[i+1]){
                max = i;
                break;
            }
        }
        for (int i = max; i < arr.length - 1; i++){
            if (arr[i] > arr[i+1]){
                max = i;
            }
        }
        
        return max;
    }
}
