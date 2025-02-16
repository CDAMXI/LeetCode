package UglyNumbers;

import java.util.*;

public class UglyNumbersv1 {
    public static void main(String[] args) {
        System.out.println(isUgly(6));  // true
        System.out.println(isUgly(8));  // true
        System.out.println(isUgly(1));  // true
        System.out.println(isUgly(14));  // false
    }

    public static boolean isUgly(int n){
        if (n <= 1) {return false;}
        int[] divs = divisors(n);
        for (int i = 0; i < divs.length; i++) {
            if (divs[i] != 2 && divs[i] != 3 && divs[i] != 5) {return false;}
        }
        return true;
    }

    public static int[] divisors(int n){
        ArrayList<Integer> divs = new ArrayList<>();
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (i == n / i) {divs.add(i);}
                else{
                    divs.add(i);
                    divs.add(n / i);
                }
            }
        }
        divs.sort(null);
        return divs.stream().mapToInt(i -> i).toArray();
    }

    public static int cantDiv(int n){
        int cont = 1;
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (i == n / i) {cont++;}
                else{cont += 2;}
            }
        }
        return cont;
    }
}
