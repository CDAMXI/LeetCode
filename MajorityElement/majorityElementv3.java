package MajorityElement;

public class majorityElementv3 {

public class majorityElementv2 {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 2, 3}));  // Output: 3
        System.out.println(majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));  // Output: 2
        System.out.println(majorityElement(new int[]{2, 2, 1, 1, 1}));  // Output: 1
    }

    public static int majorityElement(int[] nums) {
        int candidate = 0, count = 0;
        
        // Fase 1: Encontrar un candidato potencial
        for (int num : nums) {
            if (count == 0) {
                candidate = num;  // Asignamos el nuevo candidato
            }
            count += (num == candidate) ? 1 : -1;  // Incrementamos o decrementamos el contador
        }
        
        // Fase 2: (Opcional) Validación (no es necesaria en este caso, ya que el enunciado garantiza que hay un elemento mayoritario)
        // count = 0;
        // for (int num : nums) {
        //     if (num == candidate) count++;
        // }
        // if (count > nums.length / 2) return candidate;

        return candidate;  // El candidato será el mayoritario
    }
}

}
