package RomanToInteger;

import java.util.*;

public class RomanToIntegerv1 {
    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s){
        int num = 0;
        if (s.length() == 1) {
            if(s.startsWith("I")){num += 1;}
            else if(s.startsWith("V")){num += 5;}
            else if(s.startsWith("X")){num += 10;}
            else if(s.startsWith("L")){num += 50;}
            else if(s.startsWith("C")){num += 100;}
            else if(s.startsWith("D")){num += 500;}
            else if(s.startsWith("M")){num+=1000;}
        }else{
            for(int i = 0; i < s.length(); i++){
                if (esMenorQueSiguiente(s, i)) {
                    switch (s.charAt(i)) {
                        case 'I' -> num -= 1;
                        case 'V' -> num  -= 5;
                        case 'X' -> num  -= 10;
                        case 'L' -> num  -= 50;
                        case 'C' -> num  -= 100;
                        case 'D' -> num -= 500;
                        default -> num-=1000;
                    }
                } else{
                    switch (s.charAt(i)) {
                        case 'I' -> num += 1;
                        case 'V' -> num += 5;
                        case 'X' -> num += 10;
                        case 'L' -> num += 50;
                        case 'C' -> num += 100;
                        case 'D' -> num += 500;
                        default -> num += 1000;
                    }
                }
            }
        }
        return num;
    }

    private static boolean esMenorQueSiguiente(String s, int pos){

        Map<Character, Integer> valores = Map.of('I', 1,'V', 5,'X', 10,
        'L', 50,'C', 100,'D', 500,'M', 1000);
        int valorActual = 0, valorSiguiente = 0;
        if (pos < s.length() - 1) {
            char actual = s.charAt(pos);
            char siguiente = s.charAt(pos + 1);
    
            // Get the numeric values of the Roman characters
            valorActual = valores.get(actual);
            valorSiguiente = valores.get(siguiente);
        }
        
        return valorActual < valorSiguiente;
    }
}
