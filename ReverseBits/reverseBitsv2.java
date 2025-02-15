public class reverseBitsv2 {
    public static void main(String[] args) {
        //Se producen excepciones porque al pasar 43261596 a binario, el valor supera los limites de un int
        //System.out.println(reverseBits(Integer.parseInt(Integer.toBinaryString(43261596))));
        //System.out.println(reverseBits(Integer.parseInt(Integer.toBinaryString(-3))));
    }

    public static int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) { // Procesar los 32 bits de `n`
            result <<= 1;             // Desplazar `result` hacia la izquierda
            result |= (n & 1);        // Agregar el bit menos significativo de `n` a `result`
            n >>>= 1;                 // Desplazar `n` hacia la derecha (sin signo)
        }
        return result;
    }
    
}
