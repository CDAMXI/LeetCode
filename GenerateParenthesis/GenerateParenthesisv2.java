import java.util.*;

public class GenerateParenthesisv2{
    public static void main(String[] args){
        System.out.println("Para 1: " + generateParenthesis(1) + "\n");
        System.out.println("Para 2: " + generateParenthesis(2) + "\n");
        System.out.println("Para 3: " + generateParenthesis(3) + "\n");
        System.out.println("Para 4: " + generateParenthesis(4) + "\n");
        System.out.println("Para 5: " + generateParenthesis(5) + "\n");
        System.out.println("Para 6: " + generateParenthesis(6) + "\n");
        System.out.println("Para 7: " + generateParenthesis(7) + "\n");
        System.out.println("Para 8: " + generateParenthesis(8) + "\n");
        System.out.println("Para 9: " + generateParenthesis(9) + "\n");
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private static void backtrack(List<String> result, String current, int open, int close, int max) {
        // Si la longitud de la combinación es igual a 2 * n, es válida.
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        // Agregar un paréntesis de apertura si no hemos alcanzado el límite.
        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }

        // Agregar un paréntesis de cierre si hay suficientes abiertos para cerrarlos.
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }
}
