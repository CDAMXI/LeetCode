package FirstMissingPositive;

public class FirstMissingPositivev2 {
    public static void main(String[] args) {
        System.out.println(FirstMissingPositiveNum(new int[] {1, 2, 0}));         // Salida: 3
        System.out.println(FirstMissingPositiveNum(new int[] {3, 4, -1, 1}));     // Salida: 2
        System.out.println(FirstMissingPositiveNum(new int[] {7, 8, 9, 11, 12})); // Salida: 1
        System.out.println(FirstMissingPositiveNum(new int[] {-1, -2, -60, 40, 43})); // Salida: 1
    }

    public static int FirstMissingPositiveNum(int[] nums) {
        int n = nums.length;

        // Coloca cada número en su posición correcta (nums[i] -> nums[nums[i]-1])
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        // Busca el primer índice donde el número no es correcto
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // Si todos los números son correctos, el primer número positivo faltante es n + 1
        return n + 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
