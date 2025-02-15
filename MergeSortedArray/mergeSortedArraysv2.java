package MergeSortedArray;

public class mergeSortedArraysv2 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0}, nums2 = {2,5,6};
        int m = 3, n = 3;
        merge(nums1,m,nums2,n);
        print(nums1);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;  // Último índice válido en nums1
        int p2 = n - 1;  // Último índice en nums2
        int p = m + n - 1;  // Último índice del arreglo completo nums1
    
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }
    
        // Copiar los elementos restantes de nums2, si los hay
        while (p2 >= 0) {
            nums1[p] = nums2[p2];
            p2--;
            p--;
        }
    }
    
    private static void print(int[] array){
        System.out.print("[");
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.println(array[array.length - 1] + "]");
    }
}
