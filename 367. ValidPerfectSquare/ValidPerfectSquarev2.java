package ValidPerfectSquare;

public class ValidPerfectSquarev2 {
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(16)); // true
        System.out.println(isPerfectSquare(14)); // false
    }

    public static boolean isPerfectSquare(int num) {
        if (num < 1) return num == 0;
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }
}
