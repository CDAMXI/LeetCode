package ValidPerfectSquare;

public class ValidPerfectSquarev1 {
    public static void main(String[] args){
        System.out.println(isPerfectSquare(16)); // true
        System.out.println(isPerfectSquare(14)); // false
    }

    public static boolean isPerfectSquare(int num){
        if (num < 0) {return false;}
        if (num == 1 || num == 0) {return true;}
        try{
            int x = (int) Math.sqrt(num);
            return (x * x == num);
        }
        catch(ArithmeticException e){return false;}
        catch(IllegalArgumentException e){return false;}
    }
}
