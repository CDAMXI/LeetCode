package PerfectNumber;

public class PerfectNumberv2 {
    public static void main(String[] args) {
        System.out.println(checkPerfectNumber(28)); // true
        System.out.println(checkPerfectNumber(7));  // false
        System.out.println(checkPerfectNumber(1));  // false
    }

    public static boolean checkPerfectNumber(int num) {
        if (num <= 1) return false; // 1 is not perfect

        int sum = 1; // 1 is divider of all numbers

        for (int i = 2; i * i <= num; i++) { //Loop up to √num
            if (num % i == 0) {
                sum += i;
                if (i != num / i) { // Avoiding double counting the same divisor
                    sum += num / i;
                }
            }
        }

        return sum == num;
    }
}
