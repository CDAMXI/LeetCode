package RemoveElement;

public class removeElementv2 {
    public static void main(String[] args) {
        System.out.println("Solution: " + removeElement(new int[]{3,2,2,3}, 3));       
        System.out.println("Solution: " + removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));       
    }

    public static int removeElement(int[] nums, int val){
        if (nums.length == 0) {return 0;}
        int a = 0, k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[a] = nums[i]; // Actualiza el siguiente lugar en nums
                a++;
            } else{k++;}
        }

        System.out.print("[");
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) {
                System.out.print(nums[i]); // Último elemento, sin coma
            } else {
                System.out.print(nums[i] + ","); // Elementos intermedios con coma
            }
        }
        System.out.println("]"); // Cierre del formato

        return k;
    }
}