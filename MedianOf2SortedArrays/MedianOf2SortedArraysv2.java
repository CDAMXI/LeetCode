package MedianOf2SortedArrays;

public class MedianOf2SortedArraysv2 {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,3}, new int[]{2}));
        System.out.println(findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
        System.out.println(findMedianSortedArrays(new int[]{1,2}, new int[]{}));
        System.out.println(findMedianSortedArrays(new int[]{}, new int[]{3,4}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Si ambos arrays están vacíos, no tiene sentido calcular la mediana
        if (nums1.length == 0 && nums2.length == 0) {
            return -1;
        }
        
        // Asegúrate de que nums1 sea siempre el array más pequeño
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        
        int left = 0, right = nums1.length, mid = (nums1.length + nums2.length + 1) / 2;
        
        // Búsqueda binaria
        while (left <= right) {
            int partition1 = (left + right) / 2;
            int partition2 = mid - partition1;

            // Si no hay elementos a la izquierda, asignamos un valor muy bajo
            int maxLeft1 = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int minRight1 = (partition1 == nums1.length) ? Integer.MAX_VALUE : nums1[partition1];

            // Lo mismo para nums2
            int maxLeft2 = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int minRight2 = (partition2 == nums2.length) ? Integer.MAX_VALUE : nums2[partition2];

            // Comprobamos si hemos encontrado la partición correcta
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // Si la longitud es impar, la mediana es el máximo de los elementos izquierdos
                if ((nums1.length + nums2.length) % 2 == 1) {
                    return Math.max(maxLeft1, maxLeft2);
                } else {
                    // Si la longitud es par, la mediana es el promedio de los dos valores centrales
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                }
            } else if (maxLeft1 > minRight2) {
                // Nos movemos hacia la izquierda en nums1
                right = partition1 - 1;
            } else {
                // Nos movemos hacia la derecha en nums1
                left = partition1 + 1;
            }
        }
        
        // Si llegamos aquí, significa que algo salió mal
        throw new IllegalArgumentException("Input arrays are not sorted.");
    }
}
