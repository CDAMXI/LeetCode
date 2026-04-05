import java.util.Arrays;

public class SlidingWIndowMedianv3 {
    public static void main(String[] args) {
        System.out.print("[");
        SlidingWIndowMedianv3 instance = new SlidingWIndowMedianv3();
        double[] result = instance.medianSlidingWindow(new int[]{2147483647, 2147483647}, 2);
        for(int i = 0; i < result.length; i++){
            System.out.print(result[i]);
            if(i != result.length - 1){System.out.print(",");}
        }
        System.out.println("]");
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        if (k <= 0 || nums == null || nums.length == 0) return new double[0];
        boolean evenWindow = (k % 2 == 0);
        double[] result = new double[nums.length - k + 1];
        int contResult = 0;

        for(int i = 0; i <= nums.length - k; i++) {
            int[] auxArray = new int[k];
            for(int j = 0; j < k; j++) {
                auxArray[j] = nums[i + j];
            }
            Arrays.sort(auxArray);
            if (!evenWindow) {
                result[contResult] = auxArray[k / 2];
            } else {
                result[contResult] = ((long)auxArray[k / 2] + (long)auxArray[k / 2 - 1]) / 2.0;
            }
            contResult++;
        }
        return result;
    }
}
