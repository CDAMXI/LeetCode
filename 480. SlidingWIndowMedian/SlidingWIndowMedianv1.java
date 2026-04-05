public class SlidingWIndowMedianv1{
    public static void main(String[] args) {
        System.out.print("[");
        SlidingWIndowMedianv1 instance = new SlidingWIndowMedianv1();
        double[] result = instance.medianSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
        for(int i = 0; i < result.length; i++){
            System.out.print(result[i]);
            if(i != result.length - 1){System.out.print(",");}
        }
        System.out.println("]");
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        if (k <= 0 || nums == null || nums.length == 0) {return new double[0];}
        boolean evenWindow = (k % 2 == 0) ? true : false;
        double[] result = new double[nums.length - k + 1];
        int contResult = 0;
        if(!evenWindow){
            for(int i = 0; i < nums.length; i++){
                int[] auxArray = new int[k];
                for(int j = 0 ; j < k; j++){auxArray[j] = nums[i];}
                result[contResult] = auxArray[k/2];
            }
        } else{
            for(int i = 0; i < nums.length; i++){
                int[] auxArray = new int[k];
                for(int j = 0 ; j < k; j++){auxArray[j] = nums[i];}
                result[contResult] = (auxArray[k/2] + auxArray[k/2 - 1]) / 2.0;
            }
        }
        return result;
    }
}
