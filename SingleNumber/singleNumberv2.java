package SingleNumber;

public class singleNumberv2 {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2,2,1}));
        System.out.println(singleNumber(new int[]{4,1,2,1,2}));
        System.out.println(singleNumber(new int[]{1}));
    }

    public static int singleNumber(int[] nums) {
        int result = 0; // Inicializamos el resultado con 0
        for (int num : nums) {
            result ^= num; // Aplicamos XOR con cada número
        }
        return result; // El número único queda al final
    }
    
}
