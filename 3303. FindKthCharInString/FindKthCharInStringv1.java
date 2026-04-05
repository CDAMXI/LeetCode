package FindKthCharInString;

public class FindKthCharInStringv1 {
    public static void main(String[] args) {
        System.out.println(kthCharacter(5));  // Output: b
    }

    public static char kthCharacter(int k){
        String word = "a";
        while(word.length() < k) {
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()) {
                sb.append(c);
                sb.append(Character.toLowerCase(c));
            }
            word = sb.toString();
        }
        return word.charAt(k - 1);
    }
}
