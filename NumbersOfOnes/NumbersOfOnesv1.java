package NumbersOfOnes;

public class NumbersOfOnesv1 {
    public static void main(String[] args){
        System.out.println(countDigitOne(13)); // Output: 6
        System.out.println(countDigitOne(824883294)); // Output: 6
    }

    public static int countDigitOne(int n){
        if (n > 0 && n <= 9) {return 1;}
        if (n <= 0) {return 0;}
        int count = 0;
        for (int i = 1; i <= n; i++){
            int num = i;
            while (num > 0){
                if (num % 10 == 1){
                    count++;
                }
                num /= 10;
            }
        }
        return count;
    }
}
