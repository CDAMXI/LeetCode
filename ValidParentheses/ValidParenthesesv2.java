package ValidParentheses;

import java.util.*;

public class ValidParenthesesv2 {
    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([])"));
        System.out.println(isValid("([)]"));
    }

    public static boolean isValid(String s) {
    // Usar una pila para hacer seguimiento de los paréntesis abiertos
    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        // Insertar en la pila cuando hay un paréntesis de apertura
        if (c == '(' || c == '[' || c == '{') {
            stack.push(c);
        } else {
            // Verificar si la pila está vacía antes de intentar hacer pop
            if (stack.isEmpty()) {
                return false;
            }
            // Comprobar si el paréntesis de cierre coincide con el del tope de la pila
            char top = stack.pop();
            if ((c == ')' && top != '(') ||
                (c == ']' && top != '[') ||
                (c == '}' && top != '{')) {
                return false;
            }
        }
    }
    // La pila debe estar vacía si la secuencia es válida
    return stack.isEmpty();
}

}
