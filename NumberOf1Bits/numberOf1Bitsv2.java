public class numberOf1Bitsv2 {
    public static void main(String[] args){
        System.out.println(hammingWeight(11));          // Salida: 3
        System.out.println(hammingWeight(128));        // Salida: 1
        System.out.println(hammingWeight(2147483645)); // Salida: 30
    }

    public static int hammingWeight(int n){
        int count = 0;
        while (n != 0) {
            count += (n & 1); // Incrementa si el bit menos significativo es 1
            n >>>= 1;        // Desplaza los bits hacia la derecha sin signo
        }
        return count;
    }
}