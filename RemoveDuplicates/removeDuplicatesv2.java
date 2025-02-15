package RemoveDuplicates;

public class removeDuplicatesv2 {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,1,2}));
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
        System.out.println(removeDuplicates(new int[]{1,2,3,4}));
        System.out.println(removeDuplicates(new int[]{1}));
        System.out.println(removeDuplicates(new int[]{}));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0; // Caso de borde: arreglo vacío
    
        int k = 1; // Contador de elementos únicos, comenzamos con el primer elemento
        for (int i = 1; i < nums.length; i++) {
            // Si el número actual es diferente del último único encontrado
            if (nums[i] != nums[k - 1]) {
                nums[k] = nums[i]; // Actualiza el siguiente lugar en nums
                k++;               // Incrementa el contador
            }
        }
        return k; // Número de elementos únicos
    }
    
}
