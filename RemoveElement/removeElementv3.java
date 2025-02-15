package RemoveElement;

public class removeElementv3 {
    public static void main(String[] args) {
        System.out.println("Solution: " + removeElement(new int[]{3,2,2,3}, 3));       
        System.out.println("Solution: " + removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));       
    }

    public static int removeElement(int[] nums, int val){
        if (nums.length == 0) {
            return 0;
        }
        int k = 0;
        
        // Mover los valores que no son iguales a `val` al principio del array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        
        // Llenar los últimos `nums.length - k` elementos con ceros
        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }
        
        return k; // Retornar el número de elementos que no son iguales a `val`
    }
}