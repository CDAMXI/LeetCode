public class HappyNumberv1 {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
        System.out.println(isHappy(2));
    }

    public static boolean isHappy(int n){
        if (n == 1) {return true;}
        if (n == 4) {return false;}
        int sum = 0;
        while (n > 0) {
            sum += Math.pow(n % 10, 2);
            n /= 10;
        }
        return isHappy(sum);
    }
}
