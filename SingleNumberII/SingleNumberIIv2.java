import java.util.*;

public class SingleNumberIIv2 {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2,2,3,2}));
        System.out.println(singleNumber(new int[]{0,1,0,1,0,1,99}));
        System.out.println(singleNumber(new int[]{30000,500,100,30000,100,30000,100}));
    }

    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();

        // Primera pasada: Contamos las apariciones de cada número
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Segunda pasada: Encontramos el primer número que aparece solo una vez
        for (int num : nums) {
            if (countMap.get(num) == 1) {
                return num; // Retorna el primer número único encontrado
            }
        }

        return -1; // Retornar un valor por defecto si no hay números únicos
    }
}
