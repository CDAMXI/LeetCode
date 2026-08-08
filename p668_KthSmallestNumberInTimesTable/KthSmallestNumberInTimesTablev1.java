package p668_KthSmallestNumberInTimesTable;

import java.util.ArrayList;

public class KthSmallestNumberInTimesTablev1 {
    public static void main(String[] args){
        int m = 3;
        int n = 3;
        int k = 5;
        int result = findKthNumber(m, n, k);
        System.out.println(result);
    }

    public static int findKthNumber(int m, int n, int k){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                list.add(i * j);
            }
        }

        int[] arr = list.stream().mapToInt(Integer::intValue).toArray();
        java.util.Arrays.sort(arr);
        return arr[k - 1];
    }
}
