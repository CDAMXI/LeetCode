package SearchInsertPosition;

public class searchInsertPositionv2 {
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[] {1, 3, 5, 6}, 5)); // Output: 2
        System.out.println(searchInsert(new int[] {1, 3, 5, 6}, 2)); // Output: 1
        System.out.println(searchInsert(new int[] {1, 3, 5, 6}, 7)); // Output: 4
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Evitar overflow al calcular el medio

            if (nums[mid] == target) {
                return mid; // Elemento encontrado
            } else if (nums[mid] < target) {
                left = mid + 1; // Buscar en la mitad derecha
            } else {
                right = mid - 1; // Buscar en la mitad izquierda
            }
        }

        // Si no se encuentra, `left` será la posición de inserción
        return left;
    }
}
