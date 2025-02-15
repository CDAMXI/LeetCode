package MajorityElement;

import java.util.HashMap;

public class majorityElementv2 {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3,2,3}));
        System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2}));
    }

    public static int majorityElement(int[] nums) {
        int value = 0, n = nums.length / 2;  // n es la mitad del tamaño del array
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Contar la frecuencia de cada número en nums
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);  // Si num no está, lo inicializamos en 0 y lo incrementamos
        }

        // Buscar el número cuya frecuencia es mayor que n
        for (int key : map.keySet()) {
            if (map.get(key) > n) {
                value = key;  // Guardamos el valor si su frecuencia es mayor que n
                break;  // Terminar el bucle una vez encontramos el número mayoritario
            }
        }

        return value;
    }
}
